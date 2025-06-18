import java.util.Scanner;

public class AthleteRunCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1 in meters: ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2 in meters: ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side 3 in meters: ");
        double side3 = sc.nextDouble();

        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000; // 5 km = 5000 meters

        double rounds = totalDistance / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}
