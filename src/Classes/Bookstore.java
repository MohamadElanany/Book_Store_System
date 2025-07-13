package Classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookstore {

    private final Map<String, Book> inventory = new HashMap<>();
    private final int currentYear = 2025;

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Quantum book store: Added book '" + book.getTitle() + "' (ISBN: " + book.getISBN() + ")");
    }

    public List<Book> removeOutdatedBooks(int years) {
        List<Book> removed = new ArrayList<>();
        List<String> toRemove = new ArrayList<>();

        for (Book book : inventory.values()) {
            if (currentYear - book.getYear() > years) {
                toRemove.add(book.getISBN());
                removed.add(book);
            }
        }

        for (String isbn : toRemove) {
            inventory.remove(isbn);
            System.out.println("Quantum book store: Removed outdated book ISBN " + isbn);
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book not found with ISBN " + isbn);
        }
        if (!book.canBePurchased()) {
            throw new IllegalStateException("Quantum book store: Book not available for purchase");
        }

        book.processPurchase(quantity, email, address);
        return book.getPrice() * quantity;
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

}
