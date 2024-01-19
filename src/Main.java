import Proxy.BookBasedOnAgeProxy;
import Singleton.Bookstore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setting variables
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

        // Starting the bookstore loop
        bookStoreLoop(scanner, bookstore);
        scanner.close();
    }

    private static int checkForAge(Scanner scanner) {
        Boolean isNotNumber = true;
        int age = 0;
        do {
            // Checking for number input
            try {
                age = Integer.parseInt(scanner.nextLine());
                isNotNumber = false;
            } catch (NumberFormatException ex) {
                System.out.println("This is not a number, please use a number");
            }
        } while (isNotNumber);
        return age;
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