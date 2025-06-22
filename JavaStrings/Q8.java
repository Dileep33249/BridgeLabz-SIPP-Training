import java.util.*;

public class Q8 {
    public static void generateException() {
        String str = "abc";
        int num = Integer.parseInt(str);
    }

    public static void handleException() {
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        }
    }

    public static void main(String[] args) {
      
        handleException();
    }
}
