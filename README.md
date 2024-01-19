# Bookstore Application

## Overview

The Bookstore application is a simple command-line interface (CLI) program that simulates a bookstore management system. Users can interact with the bookstore by entering commands to perform various actions, such as viewing available books, adding books to the shopping cart, checking out, and more.

## Features
- Singleton Design Pattern: The application is designed as a singleton, ensuring that only one instance of the Bookstore class exists throughout the program's lifecycle. This guarantees a single point of access to the bookstore functionality.

- Command Design Pattern: Utilizes the Command design pattern to encapsulate and execute operations like adding books to the shopping cart and showing the sum of prices. This provides a flexible and extensible way to manage user commands.

- Observer Design Pattern: Implements the Observer design pattern to notify observers (User and BookObserver) when a discount is applied to a randomly selected book. Observers are notified when a discount occurs.

- Decorator Design Pattern: Demonstrates the Decorator design pattern with the GiftWrappingDecorator class, allowing users to choose gift wrapping for their purchased books.

- Exception Handling: Incorporates basic exception handling for scenarios such as book not found or errors during random discount generation.


## Commands

- help: Displays a list of available commands.
- show-books: Shows all available books in the bookstore.
- show-info: Provides detailed information about a selected book.
- add-to-cart: Adds a book to the shopping cart, optionally with gift wrapping.
- show-cart: Displays the books in the shopping cart and calculates the total price.
- checkout: Completes the purchase, displays the total amount, and resets the shopping cart.
- quit: Exits the bookstore application.

## Usage Example

Enter show-books to view the available books and their prices.
Enter add-to-cart to add a book to the shopping cart, specifying whether you want gift wrapping.
Enter show-cart to see the books in the shopping cart and the total price.
Enter checkout to complete the purchase and reset the shopping cart.

## Contributions

### Simon Manassé
Implemented the following design patterns:

#### Command
The ShoppingCartCommand interface defines a standard execute() method for concrete command classes. The ShoppingCartInvoker class manages a list of commands, allowing dynamic composition and execution.

The ShowBooksInCart class, implementing the ShoppingCartCommand, displays books in the shopping cart with details such as title, price, and an indication if gift-wrapped. The ShowSumOfPricesCommand class calculates and displays the total sum of prices, accounting for base prices and additional fees for wrapped books.

These components showcase the Command pattern's flexibility, separating command execution from its invocation, promoting modularity, and facilitating the addition of new commands without altering existing code.

#### Decorator

The BookDecorator abstract class extends the Book class and serves as the base for concrete decorators, maintaining a reference to a Book instance. The GiftWrappingDecorator class extends BookDecorator and adds functionality by wrapping a book as a gift. The displayInfo() method is overridden to set the wrapping status and return a message indicating that the book has been wrapped. This approach allows dynamic augmentation of book objects with various decorations while keeping the core functionality intact.

#### Main

It begins by initializing necessary components, such as a scanner for user input, a proxy for handling age-based book access (BookBasedOnAgeProxy), and the central bookstore instance, managed as a singleton (Bookstore). The user is prompted to input their age, and the age-based proxy is then utilized to set and retrieve a list of books suitable for the provided age. The bookstore's inventory is updated accordingly, and the application enters a loop where the user can interact with the bookstore by entering commands. The loop continues until the user inputs "quit," signaling the end of the interaction. The code demonstrates the integration of age-based book access using a proxy and user interaction with the bookstore through a command-line interface.

### Dezső-Dániel Bartha:
Implemented the following design patterns: 

#### Factory 
The abstract class Book serves as the common interface with attributes like title, author, price, type, summary, and a boolean flag indicating if the book is wrapped. It includes a method displayInfo() for displaying book information and getters and setters for its attributes. 
The BookFactory interface declares a method createBook to be implemented by concrete factories. Two concrete book classes, FictionBook and NonFictionBook, extend the Book class, each representing a specific type of book. Corresponding factories, FictionBookFactory and NonFictionBookFactory, implement the BookFactory interface, providing methods to create instances of their respective book types based on input information.

#### Observer
The BookObserver class serves as an observer, and its update method is invoked when the observed book's price changes. The method calculates and displays the discounted price, updates the book's price accordingly, and prints a notification. The User class extends BookObserver and overrides the update method to provide a custom notification when a new book is on sale. 

#### Proxy
BookBasedOnAgeProxy class that acts as a proxy for accessing different types of books based on the user's age. It contains information about fantasy, mature fiction, non-fiction, and mature non-fiction books. The class uses the Factory Design Pattern to create instances of these books. The setBooksBasedOnAge method populates a list of books based on the user's age, restricting access to mature fiction and non-fiction books for users under 18. The getInfo method returns a message indicating the user's access status, and the getListOfBooks method retrieves the list of available books. Additionally, the class includes methods to set the user's age.

### Implemented together: Singleton

The class employs various design patterns, including Singleton, Command, Observer, and Decorator. Users can navigate the bookstore using commands such as displaying available books, adding to the shopping cart, checking out, and more. The code handles book information, cart management, and user input processing. Notably, it includes a Decorator (GiftWrappingDecorator) for adding gift-wrapping functionality to books in the shopping cart. The main loop continuously prompts users for commands until the "quit" command is entered. Overall, this application encapsulates bookstore functionalities, demonstrating the use of design patterns to enhance modularity, flexibility, and maintainability in the codebase.

https://github.com/DanielBartha/Book-Store
