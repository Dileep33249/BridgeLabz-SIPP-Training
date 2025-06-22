import java.util.Scanner;

public class Q18 {

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) str.charAt(count++);
        } catch (Exception e) {
            return count;
        }
    }

    public static String[] manualSplit(String str) {
        int len = getLength(str);
        String[] words = new String[len];
        int wordCount = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else if (word.length() > 0) {
                words[wordCount++] = word.toString();
                word.setLength(0);
            }
        }

        if (word.length() > 0) {
            words[wordCount++] = word.toString();
        }

        // Resize array
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) result[i] = words[i];
        return result;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] builtIn = input.split(" ");
        String[] manual = manualSplit(input);

        System.out.println("Manual Matches Built-in Split: " + compareArrays(builtIn, manual));
    }
}
