package Decorator;

import Factory.Book;

public class GiftWrappingDecorator extends BookDecorator {
    private Book book;
    public GiftWrappingDecorator(Book book) {
        super(book);
        this.book=book;
    }

    @Override
    public String displayInfo() {
        book.setIsWrapped(true);
        return book.getTitle() + " has been with wrapped ";
    }
}