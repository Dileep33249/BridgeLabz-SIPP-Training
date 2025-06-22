import java.util.*;

public class Q6 {
    public static char[] toCharArrayManual(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] manual = toCharArrayManual(text);
        char[] builtin = text.toCharArray();
        System.out.println("Arrays equal: " + compareCharArrays(manual, builtin));
    }
}