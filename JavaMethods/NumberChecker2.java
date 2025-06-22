import java.util.Scanner;

public class NumberChecker2 {

    public static int[] getProperDivisors(int num) {
        int count = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) count++;
        }

        int[] divisors = new int[count];
        int idx = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) divisors[idx++] = i;
        }

        return divisors;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    public static boolean isPerfect(int num) {
        return sum(getProperDivisors(num)) == num;
    }

    public static boolean isAbundant(int num) {
        return sum(getProperDivisors(num)) > num;
    }

    public static boolean isDeficient(int num) {
        return sum(getProperDivisors(num)) < num;
    }

    public static boolean isStrong(int num) {
        int sum = 0, temp = num;
        while (temp > 0) {
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }
        return sum == num;
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println("Perfect: " + isPerfect(num));
        System.out.println("Abundant: " + isAbundant(num));
        System.out.println("Deficient: " + isDeficient(num));
        System.out.println("Strong: " + isStrong(num));
    }
}
