package Observer;

public class User extends BookObserver {
    @Override
    public void update(Book book) {
        System.out.println("Notification: " + book.displayInfo() + " is now available!");
    }
}