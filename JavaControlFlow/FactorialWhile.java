import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid input. Enter a positive integer.");
            return;
        }

        long fact = 1;
        int i = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }

        System.out.println("Factorial of " + n + " is: " + fact);
    }
}
