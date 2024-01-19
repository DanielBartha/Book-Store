package Command;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import Factory.Book;

public class ShowBooksInCart implements ShoppingCartCommand {
    private List<Book> booksInShoppingCart = new ArrayList<>();

    public ShowBooksInCart() {

    }

    public void addToCart(Book book) {
        this.booksInShoppingCart.add(book);
    }

    @Override
    public void execute() {
        if (this.booksInShoppingCart.size() == 0) {
            System.out.println("You have no books in your cart");
        } else {
            System.out.println("Books added to your shopping cart:");
            for (Book book : booksInShoppingCart) {
                System.out.println(MessageFormat.format("Book title: {0}{1}\n Price: {2}€", 
                                        book.getTitle(),
                                        book.getIsWrapped() ? "(Wrapped)" : "",
                                        book.getIsWrapped() ? book.getPrice()+10:book.getPrice() 
                                        ));

            }
        }
    }

    public List<Book> getBooksInShoppingCart() {
        return this.booksInShoppingCart;
    }
}