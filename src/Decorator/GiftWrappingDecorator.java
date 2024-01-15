package Decorator;

import Factory.Book;

public class GiftWrappingDecorator extends BookDecorator {
    public GiftWrappingDecorator(Book book) {
        super(book);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " with Gift Wrapping";
    }
}