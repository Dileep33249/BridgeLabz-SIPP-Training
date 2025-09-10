interface Device {
    void turnOn();
    void turnOff();
}

class Light implements Device {
    public void turnOn() { System.out.println("Light turned ON."); }
    public void turnOff() { System.out.println("Light turned OFF."); }
}

class AC implements Device {
    public void turnOn() { System.out.println("AC turned ON."); }
    public void turnOff() { System.out.println("AC turned OFF."); }
}

class TV implements Device {
    public void turnOn() { System.out.println("TV turned ON."); }
    public void turnOff() { System.out.println("TV turned OFF."); }
}

public class SmartDeviceControl {
    public static void main(String[] args) {
        Device light = new Light();
        Device ac = new AC();
        Device tv = new TV();

        light.turnOn(); ac.turnOn(); tv.turnOn();
        light.turnOff(); ac.turnOff(); tv.turnOff();
    }
}