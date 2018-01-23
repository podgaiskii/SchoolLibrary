package main.java.xml;

import main.java.subj.Pupil;

import java.util.Comparator;

public class DownwardsPupilsComparator implements Comparator<Pupil> {

    @Override
    public int compare(Pupil left, Pupil right) {
        return left.getBooksRead() == right.getBooksRead() ?
                left.getBirthdate().compareTo(right.getBirthdate()) : left.getBooksRead() - right.getBooksRead();
    }
}
