import java.util.Scanner;

public class FactorFinderWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input.");
            return;
        }

        int counter = 1;
        while (counter < number) {
            if (number % counter == 0)
                System.out.println(counter);
            counter++;
        }
    }
}
