package Classes;

public class EBook extends Book {

    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    @Override
    public boolean canBePurchased() {
        return true;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        if (quantity != 1) {
            throw new IllegalArgumentException("Quantum book store: Can only purchase 1 copy of EBook");
        }
        System.out.println("Quantum book store: Sending '" + Title + "' (" + fileType + ") to " + email);
    }

    public String getFileType() { return fileType; }

}
