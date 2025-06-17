import java.util.Scanner;

public class Q9_SumNaturalWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int sum = 0, i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }

        int sumFormula = n * (n + 1) / 2;

        System.out.println("Sum using while loop: " + sum);
        System.out.println("Sum using formula: " + sumFormula);
        System.out.println("Both results are " + (sum == sumFormula ? "correct" : "not matching"));
    }
}
