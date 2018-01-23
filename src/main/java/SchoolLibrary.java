package main.java;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SchoolLibrary {

    public static void main(String[] args) {
        while (true) {
            switch (getChoice()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            System.out.println(getChoice());
        }
    }

    private static void showMenu() {
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. View the list of available for reading publications");
        System.out.println("2. View report on the pupils who have read more than 1 book");
        System.out.println("3. View report on the pupils who have read less than or equal to 2 books");
        System.out.print("Make your choice: ");
    }

    private static int getChoice() {
        showMenu();
        Scanner in = new Scanner(System.in);
        try {
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                if (choice < 1 || choice > 3) {
                    throw new NoSuchElementException();
                }
                return choice;
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            System.err.println("Input error! There should be only numbers from 1 to 3!");
            try {
                System.in.skip(System.in.available());
            } catch (IOException e1) { }
        } catch (Exception e) {
            System.err.println("Unexpected exception:");
            e.printStackTrace();
        }
        return -1;
    }

    private static void viewPublications() {

    }

}
