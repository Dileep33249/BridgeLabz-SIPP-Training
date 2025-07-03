public class Booklibrary {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    public void displayBook() {
        System.out.println(ISBN + " - " + title);
    }
}
