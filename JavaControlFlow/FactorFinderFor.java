import java.util.Scanner;

public class FactorFinderFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Not a positive number.");
            return;
        }

        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                System.out.println(i);
        }
    }
}
