import java.util.Scanner;

public class SplitTextMinMax {

    public static String[] splitText(String text) {
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; ; i++) {
            try {
                char c = text.charAt(i);
                if (c != ' ' && !inWord) {
                    wordCount++;
                    inWord = true;
                } else if (c == ' ') {
                    inWord = false;
                }
            } catch (Exception e) {
                break;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; ; i++) {
            try {
                char c = text.charAt(i);
                if (c != ' ') {
                    current.append(c);
                } else if (current.length() > 0) {
                    words[wordIndex++] = current.toString();
                    current.setLength(0);
                }
            } catch (Exception e) {
                if (current.length() > 0) {
                    words[wordIndex] = current.toString();
                }
                break;
            }
        }
        return words;
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

    // Method to get word with length array
    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findMinMaxLength(String[][] wordLenArray) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String[] pair : wordLenArray) {
            int len = Integer.parseInt(pair[1]);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String input = sc.nextLine();

        String[] words = splitText(input);
        String[][] wordLenArray = getWordLengthArray(words);
        int[] minMax = findMinMaxLength(wordLenArray);

        System.out.println("Shortest word length: " + minMax[0]);
        System.out.println("Longest word length: " + minMax[1]);
    }
}
