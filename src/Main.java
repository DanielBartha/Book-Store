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

        Boolean shouldContinue = true;

        String userInput = "";

        do {
            userInput = scanner.nextLine();
            if(userInput.equals("quit")){
                shouldContinue = false;
            }
            bookstore.handleInput(userInput);
        } while (shouldContinue);
        scanner.close();
    }
}