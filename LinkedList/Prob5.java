public class LibraryManagementSystem {
    static class Book {
        String title;
        String author;
        String genre;
        int id;
        boolean available;
        Book next;
        Book prev;

        Book(String title, String author, String genre, int id, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.id = id;
            this.available = available;
        }
    }

    Book head = null;
    Book tail = null;

    public void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos == 0) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        Book temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, available);
            return;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeById(int id) {
        if (head == null) return;
        Book temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void updateAvailability(int id, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = newStatus;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitleOrAuthor(String keyword) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + temp.id + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.available);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matching book found.");
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.available);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.available);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();

        lib.addAtBeginning("The Hobbit", "Tolkien", "Fantasy", 101, true);
        lib.addAtEnd("1984", "Orwell", "Dystopian", 102, true);
        lib.addAtPosition(1, "Foundation", "Asimov", "Sci-Fi", 103, false);

        System.out.println("--- Forward Display ---");
        lib.displayForward();

        System.out.println("\n--- Backward Display ---");
        lib.displayBackward();

        System.out.println("\n--- Search by Author ---");
        lib.searchByTitleOrAuthor("Asimov");

        System.out.println("\n--- Update Availability ---");
        lib.updateAvailability(103, true);
        lib.displayForward();

        System.out.println("\n--- Remove Book with ID 101 ---");
        lib.removeById(101);
        lib.displayForward();

        System.out.println("\n--- Count Books ---");
        lib.countBooks();
    }
}
