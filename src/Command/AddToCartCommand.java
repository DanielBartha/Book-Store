package Command;

import Factory.Book;

public class AddToCartCommand implements ShoppingCartCommand {
    private Book book;

    public AddToCartCommand(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        // Logic to add book to shopping cart
        System.out.println("Added " + book.displayInfo() + " to the shopping cart.");
    }
}