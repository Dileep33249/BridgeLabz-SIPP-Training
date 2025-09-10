interface VehicleDashboard {
    void displaySpeed(int speed);

    default void displayBattery(int battery) {
        System.out.println("Battery: " + battery + "%");
    }
}

class CarDashboard implements VehicleDashboard {
    public void displaySpeed(int speed) {
        System.out.println("Car speed: " + speed + " km/h");
    }
}

class ElectricCarDashboard implements VehicleDashboard {
    public void displaySpeed(int speed) {
        System.out.println("Electric Car speed: " + speed + " km/h");
    }
    public void displayBattery(int battery) {
        System.out.println("Electric Car Battery: " + battery + "%");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        VehicleDashboard car = new CarDashboard();
        VehicleDashboard eCar = new ElectricCarDashboard();

        car.displaySpeed(80);
        eCar.displaySpeed(100);
        eCar.displayBattery(85);
    }
}