import java.util.*;

public class Q2 {
    public static void generateException() {
        String text = "sample";
        String result = text.substring(5, 2);
    }

    public static void handleException() {
        try {
            String text = "sample";
            String result = text.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        handleException();
    }
}
