public class HandshakeCalculator {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        int numberOfStudents = 5; 
        System.out.println("Maximum number of handshakes: " + calculateHandshakes(numberOfStudents));
    }
}
