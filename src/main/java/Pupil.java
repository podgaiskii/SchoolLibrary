package main.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pupil {

    private String name;
    private String surname;
    private Date birthdate;
    private int booksRead;

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
        return new SimpleDateFormat("dd-MM-yyyy").format(birthdate);
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(int booksRead) {
        this.booksRead = booksRead;
    }
}
