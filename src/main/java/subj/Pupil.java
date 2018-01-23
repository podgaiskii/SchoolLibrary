package main.java.subj;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pupil {

    private String name;
    private String surname;
    private Date birthdate;
    private int booksRead;
    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getFormattedBirthdate() {
        return dateFormat.format(birthdate);
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = dateFormat.parse(birthdate, new ParsePosition(0));
    }

    public int getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(int booksRead) {
        this.booksRead = booksRead;
    }

    public String getFullData(boolean includingBirthdate) {
        StringBuilder sb = new StringBuilder(name);
        sb.append(' ');
        sb.append(surname);
        if (includingBirthdate) {
            sb.append(", ");
            sb.append(getFormattedBirthdate());
        }
        sb.append(": ");
        sb.append(booksRead);
        sb.append(" book(s) read");
        return sb.toString();
    }

}
