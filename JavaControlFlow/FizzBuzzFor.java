import java.util.Scanner;

public class FizzBuzzFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();

        if (limit <= 0) {
            System.out.println("Not a positive integer.");
            return;
        }

        for (int i = 1; i <= limit; i++) {
            if (i % 15 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
}
