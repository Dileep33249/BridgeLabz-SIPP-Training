import java.util.Scanner;

public class LowercaseConversionComparison {

    public static String toLowerCaseManual(String text) {
        StringBuilder lowerText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            lowerText.append(ch);
        }
        return lowerText.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String originalText = sc.nextLine();

        String builtInLower = originalText.toLowerCase();
        String manualLower = toLowerCaseManual(originalText);
        
        boolean areEqual = compareStrings(builtInLower, manualLower);
        System.out.println("Original Text     : " + originalText);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Manual Lowercase  : " + manualLower);
        System.out.println("Are both equal?   : " + areEqual);
    }
}
