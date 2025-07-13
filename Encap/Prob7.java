abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    public RideVehicle(String id, String name, double rate) {
        this.vehicleId = id;
        this.driverName = name;
        this.ratePerKm = rate;
    }

    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.println("Driver: " + driverName + ", Rate/km: " + ratePerKm);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Auto extends RideVehicle implements GPS {
    private String location;

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
        this.location = "Stand";
    }

    public double calculateFare(double distance) {
        return ratePerKm * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
