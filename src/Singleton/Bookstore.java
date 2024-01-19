package Singleton;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Command.ShoppingCartInvoker;
import Command.ShowBooksInCart;
import Command.ShowSumOfPricesCommand;
import Decorator.GiftWrappingDecorator;
import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBookFactory;
import Observer.BookObserver;
import Observer.User;

public class Bookstore {

    private Scanner scanner = new Scanner(System.in);

    private static Bookstore instance;
    private BookFactory bookFactory = new FictionBookFactory();

    private List<Book> bookList = new ArrayList<>();
    private List<Integer> bookIdsNotOnSale = new ArrayList<>();
    private List<Book> cart = new ArrayList<>();
    private BookObserver bookObserver = new BookObserver();
    private User user = new User();


    private static String[] bookStoreCommands = {
            "help        | shows all the commands that you can use",
            "show-books  | shows all available books",
            "sort-by     | use this to sort the list of books",
            "show-info   | gives you a summary of a selected book",
            "add-to-cart | add a book to your cart",
            "show-cart   | see your cart",
            "quit        | quit the Book Store" };

    private Bookstore() {
        // Private constructor to prevent instantiation

        System.out.println("You can use the following commands to navigate the Book Store:");
        shoppingCartInvoker.addCommand(addToCartCommand);
        shoppingCartInvoker.addCommand(showSumOfPricesCommand);

        showHelp();
    }

    private void showHelp() {
        for (String bookCommand : bookStoreCommands) {
            System.out.println(bookCommand);
        }
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

    public void addToCart(String bookTitle) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                cart.add(book);
                System.out.println("Book successfully added to cart");
                notifyObservers(book); // Notify observers about the added book
                return;
            }
        }

        System.out.println("Book not found. Please check the title and try again.");
    }

    public void showCart() {
        System.out.println("Books in your cart:");
        for (Book book : cart) {
            System.out.println(book.getTitle());
        }
    }

    public void handleInput(String userInput) {
        switch (userInput) {
            case "help":
                showHelp();
                break;

            case "show-books":
                for (Book book : bookList) {
                    System.out.println(MessageFormat.format("Book title: {0}  Book Price: {1} ", book.getTitle(),
                            book.getPrice()));
                }
                break;

            case "sort-by":
                System.out.println(userInput);
                break;

            case "show-info":
                System.out.print("Please tell me which book you want to know more about: ");
                String bookToShow = scanner.nextLine();
                int bookId = checkBookIdInList(bookToShow);
                checkIfBookExists(bookId);
                break;

            case "add-to-cart":
            System.out.println("What book would you like to add to your cart?");
            String addBookToCart = scanner.nextLine();
            System.out.println("Is it a gift? Would you like to wrap it? (+10€)[Y/N]");
            String wrapInput = scanner.nextLine();
            int idBasedOnInput = checkBookIdInList(addBookToCart);
            if(idBasedOnInput ==-1){
                System.out.println(MessageFormat.format("There are no such book as: {0}", addBookToCart));
            }else{
                askIfWrapped(wrapInput, idBasedOnInput);
                this.addToCart(addBookToCart);
            }
                break;

            case "show-cart":
                System.out.println(userInput);
                break;

            case "quit":
                System.out.println("Until next time!");
                break;

            default:
                System.out.println("I don't know this command");
                break;
        }
    }

    public int checkBookIdInList(String bookToShow) {
        for (int i = 0; i < this.bookList.size(); i++) {
            Book book = this.bookList.get(i);
            if (bookToShow.equalsIgnoreCase(book.getTitle())) {
                return  i;
            }
        }
        return -1;
    }

    public Book getBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equalsIgnoreCase(title))
                return book;
        }
        return null;
    }

    public void checkIfBookExists(int bookId){
        if (bookId != -1) {
            System.out.println("\n"+this.bookList.get(bookId).displayInfo());
        } else {
            System.out.println("\nWe don't have that book in our store");
        }
    }

    public void setBookInformation(List<Book> list) {
        this.bookList = list;
        for (int i = 0; i < this.bookList.size(); i++) {
            this.bookIdsNotOnSale.add(i);
        }
    }

    public void askIfWrapped(String wrapInput, int decoratedBookId) {
        if (wrapInput.equalsIgnoreCase("y")) {
            GiftWrappingDecorator wrapper = new GiftWrappingDecorator(this.bookList.get(decoratedBookId));
            System.out.println(wrapper.displayInfo());
        }
    }

    private void displayDiscount(int randomBook) {
        addObserver(user);
        addObserver(bookObserver);
        System.out.println();
        notifyObservers(this.bookList.get(randomBook));
        removeObserver(bookObserver);
        removeObserver(user);
  
    private void resetShoppingCart() {
        this.addToCartCommand = new ShowBooksInCart();
        this.showSumOfPricesCommand = new ShowSumOfPricesCommand();
        this.shoppingCartInvoker = new ShoppingCartInvoker();
        shoppingCartInvoker.addCommand(addToCartCommand);
        shoppingCartInvoker.addCommand(showSumOfPricesCommand);
    }
}
