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
import Observer.BookObserver;
import Observer.User;

public class Bookstore {
    // input
    private Scanner scanner = new Scanner(System.in);
    // Lists
    private List<Book> bookList = new ArrayList<>();
    private List<Integer> bookIdsNotOnSale = new ArrayList<>();
    // Counter
    private int numberOfBooksWrapped = 0;
    // Design Pattern classes
    private static Bookstore instance;
    private ShowBooksInCart addToCartCommand = new ShowBooksInCart();
    private ShowSumOfPricesCommand showSumOfPricesCommand = new ShowSumOfPricesCommand();
    private ShoppingCartInvoker shoppingCartInvoker = new ShoppingCartInvoker();
    private BookObserver bookObserver = new BookObserver();
    private User user = new User();

    private static String[] bookStoreCommands = {
            "help        | shows all the commands that you can use",
            "show-books  | shows all available books",
            "show-info   | gives you a summary of a selected book",
            "add-to-cart | add a book to your cart",
            "show-cart   | see your cart",
            "checkout    | pay for the books in your cart",
            "quit        | quit the Book Store" };

    private Bookstore() {
        System.out.println("You can use the following commands to navigate the Book Store:");
        showHelp();
        shoppingCartInvoker.addCommand(addToCartCommand);
        shoppingCartInvoker.addCommand(showSumOfPricesCommand);
    }

    private void showHelp() {
        System.out.println();
        for (String bookCommand : bookStoreCommands) {
            System.out.println(bookCommand);
        }
    }

    public static Bookstore getInstance() {
        if (instance == null) {
            instance = new Bookstore();
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
        Book book = getBookByTitle(bookTitle);
        if (book == null) {
            System.out.println("Book not found. Please check the title and try again.");
        } else {
            System.out.println("Book successfully added to cart");
            this.addToCartCommand.addToCart(book);
        }
    }

    public void showCart() {
        System.out.println("Books in your cart:");
        for (Book book : addToCartCommand.getBooksInShoppingCart()) {
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
                    System.out.println(MessageFormat.format("Book title: {0}  Book Price: {1}€ ", book.getTitle(),
                            book.getPrice()));
                }
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
                    this.bookList.remove(idBasedOnInput);
                }
                break;

            case "show-cart":
                this.showSumOfPricesCommand.setNumberOfBooksWrapped(this.numberOfBooksWrapped);
                showSumOfPricesCommand.setBookList(this.addToCartCommand.getBooksInShoppingCart());
                shoppingCartInvoker.executeCommands();
                break;
            case "checkout":
                this.showSumOfPricesCommand.setNumberOfBooksWrapped(this.numberOfBooksWrapped);
                System.out.println(MessageFormat.format("You have payed {0}€", this.showSumOfPricesCommand.getPrice()));
                resetShoppingCart();
                break;
            case "quit":
                System.out.println("Until next time!");
                break;
            default:
                System.out.println("I don't know this command");
                break;
        }
        generateRandomDiscount();
    }

    public int checkBookIdInList(String bookToShow) {
        for (int i = 0; i < this.bookList.size(); i++) {
            Book book = this.bookList.get(i);
            if (bookToShow.equalsIgnoreCase(book.getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void checkIfBookExists(int bookId) {
        if (bookId != -1) {
            System.out.println("\n" + this.bookList.get(bookId).displayInfo());
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

    public Book getBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equalsIgnoreCase(title))
                return book;
        }
        return null;
    }

    public void askIfWrapped(String wrapInput, int decoratedBookId) {
        if (wrapInput.equalsIgnoreCase("y")) {
            this.numberOfBooksWrapped++;
            GiftWrappingDecorator wrapper = new GiftWrappingDecorator(this.bookList.get(decoratedBookId));
            System.out.println(wrapper.displayInfo());
        }
    }

    private void resetShoppingCart() {
        this.numberOfBooksWrapped = 0;
        this.addToCartCommand = new ShowBooksInCart();
        this.showSumOfPricesCommand = new ShowSumOfPricesCommand();
        this.shoppingCartInvoker = new ShoppingCartInvoker();
        shoppingCartInvoker.addCommand(addToCartCommand);
        shoppingCartInvoker.addCommand(showSumOfPricesCommand);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void displayDiscount(int randomBook) {
        addObserver(user);
        addObserver(bookObserver);
        System.out.println();
        notifyObservers(this.bookList.get(randomBook));
        removeObserver(bookObserver);
        removeObserver(user);
    }

    private void generateRandomDiscount() {
        if (getRandomNumber(1, 100) <= 15) {
            try{
                int randomBook = this.bookIdsNotOnSale.remove(getRandomNumber(0, this.bookIdsNotOnSale.size()));
                displayDiscount(randomBook);
            }catch(Exception ex){

            }
        }
    }
}
