import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int num : numbers) {
            if (num > 0) {
                System.out.print(num + " is positive and ");
                System.out.println(num % 2 == 0 ? "even." : "odd.");
            } else if (num < 0) {
                System.out.println(num + " is negative.");
            } else {
                System.out.println("0 is zero.");
            }
        }

        // Compare first and last elements
        if (numbers[0] == numbers[4]) {
            System.out.println("First and last numbers are equal.");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First number is greater than last.");
        } else {
            System.out.println("First number is less than last.");
        }
    }
}
