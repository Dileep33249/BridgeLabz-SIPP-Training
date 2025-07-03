public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println(ownerName + " owns a " + vehicleType);
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}
