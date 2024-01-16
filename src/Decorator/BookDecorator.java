package Decorator;

import Factory.Book;

public abstract class BookDecorator extends Book {
    private Book book;

    public BookDecorator(Book book) {
        this.book = book;
    }

    @Override
    public String displayInfo() {
        return book.displayInfo();
    }
}