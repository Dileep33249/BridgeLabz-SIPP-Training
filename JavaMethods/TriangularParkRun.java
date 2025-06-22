import java.util.Scanner;

public class TriangularParkRun {

   
    public static double getPerimeter(double a, double b, double c) {
        return a + b + c;
    }

    
    public static int calculateRounds(double perimeter) {
        return (int) Math.ceil(5000 / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side A of the triangle (in meters): ");
        double a = sc.nextDouble();

        System.out.print("Enter side B of the triangle (in meters): ");
        double b = sc.nextDouble();

        System.out.print("Enter side C of the triangle (in meters): ");
        double c = sc.nextDouble();

        double perimeter = getPerimeter(a, b, c);
        int rounds = calculateRounds(perimeter);

        System.out.println("To complete a 5 km run, the athlete must run " + rounds + " rounds around the park.");
    }
}
