import java.util.*;

public class Q9 {
    public static void generateException() {
        String str = "abc";
        char ch = str.charAt(5);
    }

    public static void handleException() {
        try {
            String str = "abc";
            char ch = str.charAt(5);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        handleException();
    }
}
