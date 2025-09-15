import java.util.*;
import java.util.stream.Collectors;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Fiction", 300),
            new Book("Fiction", 500),
            new Book("Non-Fiction", 200),
            new Book("Science", 400),
            new Book("Science", 350)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(Collectors.groupingBy(b -> b.genre,
                Collectors.summarizingInt(b -> b.pages)));

        stats.forEach((genre, stat) -> {
            System.out.println(genre + " -> " + stat);
        });
    }
}