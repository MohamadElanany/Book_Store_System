package Classes;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, year, price, author,Type.SHOWCASE);
    }

    @Override
    public boolean canBePurchased() {
        return false;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Quantum book store: Showcase books cannot be purchased");
    }

}
