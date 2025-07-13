 interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int speed, String model) {
        this.maxSpeed = speed;
        this.model = model;
    }
}

class ElectricVehicle extends Vehicle {
    ElectricVehicle(int speed, String model) {
        super(speed, model);
    }

    void charge() {
        System.out.println("Charging electric vehicle");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(int speed, String model) {
        super(speed, model);
    }

    public void refuel() {
        System.out.println("Refueling petrol vehicle");
    }
}
