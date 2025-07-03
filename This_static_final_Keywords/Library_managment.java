public class Library_managment {
    static String libraryName = "City Library";
    final String isbn;
    String title;
    String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println(title + " | " + author + " | " + isbn);
        }
    }
}
