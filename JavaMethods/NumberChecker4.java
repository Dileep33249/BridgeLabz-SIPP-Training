import java.util.Scanner;

public class NumberChecker3 {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigits(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuck(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int num, int[] digits) {
        int n = digits.length, sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        return sum == num;
    }

    public static int[] findTwoLargest(int[] digits) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max) {
                second = max;
                max = d;
            } else if (d > second && d != max) {
                second = d;
            }
        }
        return new int[]{max, second};
    }

    public static int[] findTwoSmallest(int[] digits) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min) {
                second = min;
                min = d;
            } else if (d < second && d != min) {
                second = d;
            }
        }
        return new int[]{min, second};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] digits = getDigits(num);
        System.out.println("Digit Count: " + countDigits(num));
        System.out.println("Is Duck Number: " + isDuck(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(num, digits));

        int[] maxTwo = findTwoLargest(digits);
        System.out.println("Largest Digit: " + maxTwo[0] + ", Second Largest Digit: " + maxTwo[1]);

        int[] minTwo = findTwoSmallest(digits);
        System.out.println("Smallest Digit: " + minTwo[0] + ", Second Smallest Digit: " + minTwo[1]);
    }
}
