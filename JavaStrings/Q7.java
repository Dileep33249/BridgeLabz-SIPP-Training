import java.util.*;

public class Q7 {
    public static void generateException() {
        String[] names = {"A", "B", "C"};
        System.out.println(names[5]);
    }

    public static void handleException() {
        try {
            String[] names = {"A", "B", "C"};
            System.out.println(names[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        // generateException();
        handleException();
    }
}
