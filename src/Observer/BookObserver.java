package Observer;

import java.text.MessageFormat;

import Factory.Book;

public class BookObserver {
    public void update(Book book) {
        int percentage = 40;
        System.out.println(MessageFormat.format("The book: {0} has dropped it''s price from {1}€ to {2}€", book.getTitle(),
                book.getPrice(), discountBookBy(book,percentage)));
        book.setPrice(discountBookBy(book, percentage));
    }

    private int discountBookBy(Book book, int percentage) {
        return (int) Math.round(((double)book.getPrice() / 100) * percentage);
    }
}