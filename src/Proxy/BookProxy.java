package Proxy;

import Factory.Book;

public class BookProxy extends Book {
    private Book book;

    public BookProxy(Book book) {
        this.book = book;
    }

    @Override
    public String displayInfo() {
        // Additional logic for access control or logging
        return book.displayInfo();
    }
}
