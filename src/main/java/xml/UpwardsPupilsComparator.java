package main.java.xml;

import main.java.subj.Pupil;

import java.util.Comparator;

public class UpwardsPupilsComparator implements Comparator<Pupil> {

    @Override
    public int compare(Pupil left, Pupil right) {
        return left.getBooksRead() - right.getBooksRead();
    }

}
