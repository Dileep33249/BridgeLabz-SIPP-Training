import java.util.Scanner;

public class FactorOperations {

    public static int[] getFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }

        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[idx++] = i;
        }

        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) if (f > max) max = f;
        return max;
    }

    public static int sum(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static int product(int[] factors) {
        int prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static double cubeProduct(int[] factors) {
        double result = 1;
        for (int f : factors) result *= Math.pow(f, 3);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] factors = getFactors(num);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Greatest Factor: " + greatestFactor(factors));
        System.out.println("Sum of Factors: " + sum(factors));
        System.out.println("Product of Factors: " + product(factors));
        System.out.println("Product of Cubes of Factors: " + cubeProduct(factors));
    }
}
