public class SimpleInterest {
    public static double calculateSI(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        double p = 1000, r = 5, t = 2; 
        double si = calculateSI(p, r, t);
        System.out.println("Simple Interest: " + si);
    }
}
