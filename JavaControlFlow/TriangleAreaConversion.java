import java.util.Scanner;

public class Q18_TriangleAreaConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble();

        double areaCm2 = 0.5 * base * height;
        double areaIn2 = areaCm2 / (2.54 * 2.54); // 1 inch = 2.54 cm, so 1 sq in = 6.4516 cm²

        System.out.println("The Area of the triangle in sq in is " + areaIn2 + " and in sq cm is " + areaCm2);
    }
}
