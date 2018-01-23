package main.java.xml;

import main.java.subj.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class XMLHandler extends DefaultHandler {

    private ParsingType parsingType;
    private String element;
    private Publication publication;
    private Pupil pupil;
    private Queue<Publication> publicationsQueue;
    private Queue<Pupil> pupilsQueue;

    ParsingType getParsingType() {
        return parsingType;
    }

    void setParsingType(ParsingType parsingType) {
        this.parsingType = parsingType;
    }

    private XMLHandler() {}

    XMLHandler(ParsingType parsingType) {
        this.parsingType = parsingType;
    }

    @Override
    public void startDocument() throws SAXException {
        switch (parsingType) {
            case ALL_PUBLICATIONS:
                publicationsQueue = new LinkedList<>();
                break;
            case PUPILS_READ_MORE_THAN_ONE_BOOK:
                pupilsQueue = new PriorityQueue<>(new UpwardsPupilsComparator());
                break;
            case PUPILS_READ_AT_MOST_TWO_BOOKS:
                pupilsQueue = new PriorityQueue<>(new DownwardsPupilsComparator());
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        switch (parsingType) {
            case ALL_PUBLICATIONS:
                for (Publication publication : publicationsQueue) {
                    System.out.println(publication);
                }
                break;
            case PUPILS_READ_MORE_THAN_ONE_BOOK:
                while (pupilsQueue.iterator().hasNext()) {
                    System.out.println(pupilsQueue.poll().getFullData(false));
                }
                break;
            case PUPILS_READ_AT_MOST_TWO_BOOKS:
                while (pupilsQueue.iterator().hasNext()) {
                    System.out.println(pupilsQueue.poll().getFullData(true));
                }
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        switch (parsingType) {
            case ALL_PUBLICATIONS:
                if (element.equals("publication")) {
                    publication = new Publication();
                    publication.setType(attributes.getValue(0));
                }
                break;
            case PUPILS_READ_MORE_THAN_ONE_BOOK: case PUPILS_READ_AT_MOST_TWO_BOOKS:
                if (element.equals("pupil")) {
                    pupil = new Pupil();
                    pupil.setName(attributes.getValue(0));
                    pupil.setSurname(attributes.getValue(1));
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementContents = new String(ch, start, length);
        switch (parsingType) {
            case ALL_PUBLICATIONS:
                if (element.equals("title")) {
                    publication.setTitle(elementContents);
                    publicationsQueue.add(publication);
                }
                break;
            case PUPILS_READ_MORE_THAN_ONE_BOOK: case PUPILS_READ_AT_MOST_TWO_BOOKS:
                if (element.equals("birthdate")) {
                    pupil.setBirthdate(elementContents);
                } else if (element.equals("booksRead")) {
                    pupil.setBooksRead(Integer.parseInt(elementContents));
                    if (isPupilValid()) {
                        pupilsQueue.add(pupil);
                    }
                }
                break;
        }
    }

    private boolean isPupilValid() {
        switch (parsingType) {
            case PUPILS_READ_AT_MOST_TWO_BOOKS:
                if (pupil.getBooksRead() <= 2) {
                    return true;
                }
                break;
            case PUPILS_READ_MORE_THAN_ONE_BOOK:
                if (pupil.getBooksRead() > 1) {
                    return true;
                }
                break;
        }
        return false;
    }

}
