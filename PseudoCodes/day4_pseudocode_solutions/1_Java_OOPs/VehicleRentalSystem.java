
// Pseudocode for Vehicle Rental System
interface Rentable {
    rent();
    returnVehicle();
}

abstract class Vehicle implements Rentable {
    id;
    type;
    rent();
    returnVehicle();
}

class Car extends Vehicle {
    rent() { print("Car rented"); }
    returnVehicle() { print("Car returned"); }
}

class Bike extends Vehicle {
    rent() { print("Bike rented"); }
    returnVehicle() { print("Bike returned"); }
}

// Factory
class VehicleFactory {
    getVehicle(type) {
        if (type == "Car") return new Car();
        if (type == "Bike") return new Bike();
    }
}
