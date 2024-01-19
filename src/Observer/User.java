package Observer;

import Factory.Book;

public class User extends BookObserver {
    @Override
    public void update(Book book) {
        System.out.println("Notification: New book on sale!");
    }
}