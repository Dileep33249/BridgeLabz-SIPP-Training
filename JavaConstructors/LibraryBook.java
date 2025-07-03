public class Book {
    String title;
    String author;
    double price;
    boolean available = true;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void borrowBook() {
        if (available) {
            available = false;
        }
    }
}
