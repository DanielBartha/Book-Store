import Proxy.BookBasedOnAgeProxy;
import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBook;
import Factory.FictionBookFactory;
import Singleton.Bookstore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookBasedOnAgeProxy bookBasedOnAgeProxy = new BookBasedOnAgeProxy();
        Bookstore bookstore = Bookstore.getInstance();

        // Asking for user age
        System.out.print("Please tell me your age: ");
        int age = checkForAge(scanner);

        // Setting the age appropriate boooks
        bookBasedOnAgeProxy.setAge(age);
        bookBasedOnAgeProxy.setBooksBasedOnAge();
        System.out.println(bookBasedOnAgeProxy.getInfo());
        bookstore.setBookInformation(bookBasedOnAgeProxy.getListOfBooks());

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