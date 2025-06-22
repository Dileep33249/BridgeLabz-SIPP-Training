import java.util.Scanner;

public class Q14 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int manualLength = getLength(input);
        int builtInLength = input.length();

        System.out.println("Manual length: " + manualLength);
        System.out.println("Built-in length: " + builtInLength);
    }
}
