public class Vehiclereg {
    static double registrationFee = 750.0;
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println(ownerName + " | " + vehicleType + " | " + registrationNumber);
        }
    }
}
