package main.java.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class DataHandler {

    private void parseFile(ParsingType parsingType) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLHandler xmlHandler = new XMLHandler(parsingType);
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(getResourcePathOf(parsingType), xmlHandler);
        } catch (ParserConfigurationException e){
            throw new RuntimeException("Ошибка конфигурации",e);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка I/О потока",e);
        } catch (SAXException e) {
            throw new RuntimeException("Ошибка SAX-парсера",e);
        }
    }

    private String getResourcePathOf(ParsingType parsingType) {
        StringBuilder resourcePath = new StringBuilder(getClass().getResource("/xml/").getPath());
        switch (parsingType) {
            case ALL_PUBLICATIONS:
                resourcePath.append("Publications.xml");
                break;
            case PUPILS_READ_MORE_THAN_ONE_BOOK: case PUPILS_READ_AT_MOST_TWO_BOOKS:
                resourcePath.append("Pupils.xml");
                break;
        }
        return resourcePath.toString();
    }

    public void viewPublications() {
        parseFile(ParsingType.ALL_PUBLICATIONS);
    }

    public void viewPupilsReadAtMostTwoBooks() {
        parseFile(ParsingType.PUPILS_READ_AT_MOST_TWO_BOOKS);
    }

    public void viewPupilsReadMoreThanOneBook() {
        parseFile(ParsingType.PUPILS_READ_MORE_THAN_ONE_BOOK);
    }

}
