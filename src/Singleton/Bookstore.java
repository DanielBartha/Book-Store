package Singleton;

import java.util.ArrayList;
import java.util.List;

import Factory.Book;
import Observer.BookObserver;

public class Bookstore {
    private static Bookstore instance;

    private Bookstore() {
        // Private constructor to prevent instantiation
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
}
