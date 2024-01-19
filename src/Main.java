import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBook;
import Factory.FictionBookFactory;
import Singleton.Bookstore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookstore bookstore = Bookstore.getInstance();
        BookFactory bookFactory = new FictionBookFactory();
        bookStoreLoop(scanner, bookstore);
    }

    private static void bookStoreLoop(Scanner scanner, Bookstore bookstore){
        Boolean shouldContinue = true;
        String userInput = "";
        do {
            System.out.print("\nType a command: ");
            userInput = scanner.nextLine(); 
            if (userInput.equals("quit")) {
                shouldContinue = false;
            }
            bookstore.handleInput(userInput);
        } while (shouldContinue);
    }
}