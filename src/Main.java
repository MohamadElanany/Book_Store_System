import Classes.Bookstore;
import Classes.EBook;
import Classes.Paper_Book;
import Classes.ShowcaseBook;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bookstore store = new Bookstore();

        // Add books to inventory
        store.addBook(new Paper_Book("123", "Java Basics", "John Doe", 2020, 29.99, 10));
        store.addBook(new EBook("456", "Advanced Java", "Jane Smith", 2023, 19.99));
        store.addBook(new ShowcaseBook("789", "Future Java", "AI Author", 2030, 0.0));

        // Test purchasing
        try {
            double amount = store.buyBook("123", 2, "", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double amount = store.buyBook("456", 1, "user@example.com", "");
            System.out.println("Quantum book store: Paid amount: $" + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test showcase book purchase
        try {
            store.buyBook("789", 1, "", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test removal of outdated books (older than 4 years)
        store.removeOutdatedBooks(4);

        // Test insufficient stock
        try {
            store.buyBook("123", 100, "", "456 Elm St");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}