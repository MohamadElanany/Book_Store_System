# Quantum Bookstore

A simple Java-based bookstore application demonstrating inheritance, polymorphism, and basic inventory management.

## Project Structure

```
QuantumBookstore/
├── Classes/
│   ├── Book.java
│   ├── Paper_Book.java
│   ├── EBook.java
│   ├── ShowcaseBook.java
│   └── Bookstore.java
├── Main.java
└── README.md
```

* **Classes/Book.java**: Abstract base class defining common fields and methods for all books, including the `Type` enum (PAPER, EBOOK, SHOWCASE).
* **Classes/Paper\_Book.java**: Subclass representing physical books with stock management and `restock` logic.
* **Classes/EBook.java**: Subclass representing electronic books (always purchasable; prints download links).
* **Classes/ShowcaseBook.java**: Subclass for display-only books (cannot be purchased).
* **Classes/Bookstore.java**: Manages the inventory, adding/restocking, removing outdated books by age, and processing purchases.
* **Main.java**: Entry point demonstrating how to create the store, add books, purchase, and test different scenarios.

## Requirements

* Java 8 or higher
* Build tool (optional): Maven/Gradle or plain `javac` + `java`

## How to Compile & Run

1. **Compile** all classes:

   ```bash
   javac Classes/*.java Main.java
   ```
2. **Run** the application:

   ```bash
   java Main
   ```

You will see console output for:

* Adding or restocking books
* Shipping physical books
* Sending download links for eBooks
* Error messages when purchasing showcase books or when stock is insufficient
* Removing books older than a specified number of years

## Usage Example

```java
Bookstore store = new Bookstore();

// Add a paper book with initial stock of 10
store.addBook(new Paper_Book(
    "123", "Java Basics", "John Doe", 2020, 29.99, 10
));

// Add an eBook\store.addBook(new EBook(
    "456", "Advanced Java", "Jane Smith", 2023, 19.99
));

// Add a showcase book (cannot be purchased)
store.addBook(new ShowcaseBook(
    "789", "Future Java", "AI Author", 2030, 0.0
));

// Purchase 2 copies of the paper book
double paid = store.buyBook("123", 2, "", "123 Main St");
System.out.println("Paid amount: $" + paid);

// Purchase an eBook (sends a download link)
paid = store.buyBook("456", 1, "user@example.com", "");
System.out.println("Paid amount: $" + paid);

// Attempt to purchase a showcase book (throws exception)
store.buyBook("789", 1, "", "");

// Remove books older than 4 years
store.removeOutdatedBooks(4);

// Attempt to buy more copies than are in stock
store.buyBook("123", 100, "", "456 Elm St");
```

## Extending the Project

* Integrate real payment gateways (PayPal, Stripe)
* Persist inventory to a database (MySQL, MongoDB)
* Build a web or GUI frontend (Spring Boot, JavaFX)
* Implement user accounts and order history

