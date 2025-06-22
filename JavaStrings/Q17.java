import java.util.Scanner;

public class Q17 {

    public static int[] getTrimIndexes(String str) {
        int start = 0, end = -1;

        for (int i = 0; ; i++) {
            try {
                if (str.charAt(i) != ' ') {
                    start = i;
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

        for (int i = getLength(str) - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String customSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (getLength(s1) != getLength(s2)) return false;
        for (int i = 0; i < getLength(s1); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] trimIdx = getTrimIndexes(input);
        String trimmed = customSubstring(input, trimIdx[0], trimIdx[1]);
        String builtinTrim = input.trim();

        System.out.println("Custom Trim: [" + trimmed + "]");
        System.out.println("Built-in Trim: [" + builtinTrim + "]");
        System.out.println("Match: " + compareStrings(trimmed, builtinTrim));
    }
}
