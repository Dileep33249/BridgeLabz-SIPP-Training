import java.util.Scanner;

public class FactorCalculator {

    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }

    public static int[] getFactors(int n) {
        int size = countFactors(n);
        int[] factors = new int[size];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static int getProduct(int[] arr) {
        int product = 1;
        for (int val : arr) product *= val;
        return product;
    }

    public static int getSumOfSquares(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += Math.pow(val, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] factors = getFactors(number);
        for (int val : factors) System.out.print(val + " ");
        System.out.println();
        System.out.println(getSum(factors));
        System.out.println(getProduct(factors));
        System.out.println(getSumOfSquares(factors));
    }
}
