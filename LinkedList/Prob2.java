public class MovieManagementSystem {
    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie next;
        Movie prev;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    Movie head = null;
    Movie tail = null;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void searchByDirectorOrRating(String director, Double rating) {
        Movie temp = head;
        while (temp != null) {
            if ((director != null && temp.director.equalsIgnoreCase(director)) ||
                (rating != null && temp.rating == rating)) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void updateRatingByTitle(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
        mms.addAtPosition(1, "The Prestige", "Christopher Nolan", 2006, 8.5);

        System.out.println("--- Movies (Forward) ---");
        mms.displayForward();

        System.out.println("\n--- Movies (Backward) ---");
        mms.displayBackward();

        System.out.println("\n--- Updating Rating for 'Inception' ---");
        mms.updateRatingByTitle("Inception", 9.0);
        mms.displayForward();

        System.out.println("\n--- Searching for Director 'Christopher Nolan' ---");
        mms.searchByDirectorOrRating("Christopher Nolan", null);

        System.out.println("\n--- Removing 'The Prestige' ---");
        mms.removeByTitle("The Prestige");
        mms.displayForward();
    }
}
