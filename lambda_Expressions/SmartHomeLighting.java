import java.util.function.Consumer;

public class SmartHomeLighting {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = (location) -> System.out.println("Lights ON in " + location + " due to motion.");
        Consumer<String> timeTrigger = (location) -> System.out.println("Lights dimmed in " + location + " for evening mode.");
        Consumer<String> voiceTrigger = (location) -> System.out.println("Lights OFF in " + location + " by voice command.");

        motionTrigger.accept("Living Room");
        timeTrigger.accept("Bedroom");
        voiceTrigger.accept("Kitchen");
    }
}