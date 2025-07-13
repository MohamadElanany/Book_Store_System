package Classes;

public abstract class Book {
    protected String ISBN;
    protected String Title;
    protected int Year;
    protected double Price;
    protected String author;


    public Book(String ISBN, String title, int year, double price, String author) {
        this.ISBN = ISBN;
        Title = title;
        Year = year;
        Price = price;
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public int getYear() {
        return Year;
    }

    public double getPrice() {
        return Price;
    }

    public String getAuthor() {
        return author;
    }

    public abstract boolean canBePurchased();
    public abstract void processPurchase(int quantity, String email, String address);

}
