package Classes;

public class EBook extends Book {

    //private String fileType;

    public EBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, year, price, author, Type.EBOOK);
    }

    @Override
    public boolean canBePurchased() {
        return true;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        System.out.println("Sending download link for \"" + Title + "\" to " + email);
    }

}
