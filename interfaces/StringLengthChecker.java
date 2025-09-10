import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthChecker = str -> str.length();
        String msg = "Hello Functional Interface";
        System.out.println("Message length: " + lengthChecker.apply(msg));
    }
}