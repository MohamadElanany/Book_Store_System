package Classes;
import java.time.Year;
import java.util.*;

public class Bookstore {

    private final Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {

        if (inventory.containsKey(book.getISBN())
                && book instanceof Paper_Book) {
            Paper_Book existing = (Paper_Book) inventory.get(book.getISBN());
            existing.setStock(((Paper_Book) book).getStock());
            System.out.println("Restocked PAPER book: " + book.getTitle());
        } else {
            inventory.put(book.getISBN(), book);
            System.out.println("Added book: " + book.getTitle());
        }
    }

    public List<Book> removeOutdatedBooks(int year) {
        int currentYear = Year.now().getValue();
        List<Book> removed = new ArrayList<>();
        for (Iterator<Book> it = inventory.values().iterator(); it.hasNext(); ) {
            Book b = it.next();
            if (currentYear - b.getYear() > year) {
                removed.add(b);
                it.remove();
                System.out.println("Removed outdated ISBN: " + b.getISBN());
            }
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
