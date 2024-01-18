package Singleton;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBookFactory;
import Observer.BookObserver;

public class Bookstore {
    private static Bookstore instance;
     private BookFactory bookFactory = new FictionBookFactory();
     private Scanner scanner = new Scanner(System.in);
     private List<Book> bookList = new ArrayList<>();
     
     private Object[][] booksInfo = { 
        {"The Lord of the Rings", "J.R.R Tolkien", 60,  "The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore."},
        {"Wolf Hall", "Hilary Mantel", 50, "Thomas Cromwell proves he is an ambitious man by becoming the chief advisor to King Henry VII."},
        {"The Great Gatsby", "F. Scott Fitzgerald", 64, "Millionaire Jay Gatsby longs to be with the woman he loves, even though she’s married to someone else."},
        {"American Psycho", "Bret Easton Ellis", 55, "Patrick Bateman appears to have the perfect life, but under the surface lurks a psychopath with a lesson for all of us."},
        {"Nineteen Eighty-Four", "George Orwell", 70, "In a dystopian society where Big Brother watches everyone, Winston Smith attempts to rebel against the Party in the name of liberty and truth."},
        {"The Road", "Cormac McCarthy", 40, "A father and son walk through a post-apocalyptic America trying to survive."},
        {"To Kill a Mockingbird", "Harper Lee", 62, "Scout Finch narrates the story of how her father defended a black man in a case where he was falsely accused of raping a white girl."},
        {"Moby Dick", "Herman Melville", 35, "Ishmael, a sailor, joins the crew of a whaling ship and sets sail under the direction of a captain who is obsessed with killing the famous whale, Moby Dick."},
        {"One Flew Over the Cuckoo’s", "Ken Kesey", 50, "Chief Bromden narrates the story about how a new patient at the Oregon State mental hospital challenges the powers which aim to keep the patients imprisoned."},
        {"Catch-22", "Joseph Heller", 60, "Stationed in the Mediterranean Sea toward the end of World War II, Yossarian sees no escape from the enemy or from the army he’s a part of."},
    }; 

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
        for (Object[] book : booksInfo){
            this.bookList.add(bookFactory.createBook(book));
        }
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

    public void handleInput(String userInput) {
        switch (userInput) {
            case "help":
                showHelp();
                break;

            case "show-books":
                for(Book book: bookList){
                System.out.println(MessageFormat.format("Book title: {0}  Book Price: {1} ",book.displayTitle(),  book.displayPrice()));
                }
                break;

            case "sort-by":
                System.out.println(userInput);
                break;

            case "show-info":
                System.out.println("Please tell me which book you want to know more about: ");
                String bookToShow = scanner.nextLine();
                System.out.println(this.bookList.get(0).displayInfo());
                break;

            case "add-to-cart":
                System.out.println(userInput);
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

    private String returnBook(String title){
        return "";
    }
}
