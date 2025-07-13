package Classes;

public abstract class Book {
    protected String ISBN;
    public enum Type { PAPER, EBOOK, SHOWCASE };
    protected String Title;
    protected int Year;
    protected double Price;
    protected String author;
    protected Type type;


    public Book(String ISBN, String title, int year, double price, String author, Type type) {
        this.ISBN = ISBN;
        Title = title;
        Year = year;
        Price = price;
        this.author = author;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public abstract boolean canBePurchased();
    public abstract void processPurchase(int quantity, String email, String address);

}
