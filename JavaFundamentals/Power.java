import java.util.Scanner;

public class Power{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = input.nextDouble();
        System.out.print("Enter exponent: ");
        double exponent = input.nextDouble();
        double result = Math.pow(base, exponent);
        System.out.println("Result: " + result);
    }
}