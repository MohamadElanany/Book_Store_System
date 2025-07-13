package Classes;

public class Paper_Book extends Book {

    private int stock;

    public Paper_Book(String isbn, String title, String author, int year, double price, int stock ) {
        super(isbn, title, year, price, author,Type.PAPER);
        this.stock = stock;
    }
    @Override
    public boolean canBePurchased() {
        return stock > 0;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        if (stock < quantity) {
            throw new IllegalStateException("Quantum book store: Insufficient stock for ISBN " + ISBN);
        }
        stock -= quantity;
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '" + Title + "' to " + address);
    }

    public int getStock() { return stock; }
    public void setStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Restock amount must be > 0");
        }
        this.stock += amount;
    }
}
