package Singleton;

import java.util.ArrayList;
import java.util.List;

import Factory.Book;
import Observer.BookObserver;

public class Bookstore {
    private static Bookstore instance;

    private static String[] bookStoreCommands = {
            "help | shows all the commands that you can use",
            "show-books | shows all available books",
            "sort-by | use this to sort the list of books",
            "show-info | gives you a summary of a selected book",
            "add-to-cart | add a book to your cart",
            "show-cart | see your cart",
            "quit | quit the Book Store" };

    private Bookstore() {
        // Private constructor to prevent instantiation

        System.out.println("You can use the following commands to navigate the Book Store:");
        showHelp();
    }

    private void showHelp() {
        for (String bookCommand : bookStoreCommands) {
            System.out.println(bookCommand);
        }
    }

    public static Bookstore getInstance() {
        if (instance == null) {
            instance = new Bookstore();
            // Initialize necessary attributes
        }
        return instance;
    }

    private List<BookObserver> observers = new ArrayList<>();

    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (BookObserver observer : observers) {
            observer.update(book);
        }

    }

    public void handleInput(String userInput) {
        switch (userInput) {
            case "help":
                showHelp();
                break;

            case "show-books":
                System.out.println(userInput);
                break;

            case "sort-by":
                System.out.println(userInput);
                break;

            case "show-info":
                System.out.println(userInput);
                break;

            case "add-to-cart":
                System.out.println(userInput);
                break;

            case "show-cart":
                System.out.println(userInput);
                break;

            case "quit":
                System.out.println("Until next time!");
                break;

            default:
                System.out.println("I don't know this command");
                break;
        }
    }
}
