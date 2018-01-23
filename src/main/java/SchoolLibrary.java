package main.java;

import main.java.xml.DataHandler;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SchoolLibrary {

    public static void main(String[] args) {
        DataHandler handler = new DataHandler();
        while (true) {
            switch (getChoice()) {
                case 1:
                    handler.viewPublications();
                    break;
                case 2:
                    handler.viewPupilsReadMoreThanOneBook();
                    break;
                case 3:
                    handler.viewPupilsReadAtMostTwoBooks();
                    break;
                case 4:
                    return;
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. View the list of available for reading publications");
        System.out.println("2. View report on the pupils who have read more than 1 book");
        System.out.println("3. View report on the pupils who have read at most 2 books");
        System.out.println("4. Exit");
        System.out.print("Make your choice: ");
    }

    private static int getChoice() {
        showMenu();
        int choice = -1;
        Scanner in = new Scanner(System.in);
        try {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice < 1 || choice > 4) {
                    throw new NoSuchElementException();
                }
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            System.err.println("Input error! There should be only numbers from 1 to 4!");
            try {
                System.in.skip(System.in.available());
            } catch (IOException e1) { }
        } catch (Exception e) {
            System.err.println("Unexpected exception:");
            e.printStackTrace();
        }
        System.out.println();
        return choice;
    }

}
