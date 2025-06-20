public class Trigonometry {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        double angle = 45; 
        double[] result = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.4f, Cosine: %.4f, Tangent: %.4f\n", result[0], result[1], result[2]);
    }
}
