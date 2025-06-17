import java.util.Scanner;

public class Q15_IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer a: ");
        int a = scanner.nextInt();
        System.out.print("Enter integer b: ");
        int b = scanner.nextInt();
        System.out.print("Enter integer c: ");
        int c = scanner.nextInt();

        int op1 = a + b * c;
        int op2 = a * b + c;
        int op3 = c + a / b;
        int op4 = a % b + c;

        System.out.println("The results of Int Operations are: " + op1 + ", " + op2 + ", " + op3 + ", " + op4);
    }
}
