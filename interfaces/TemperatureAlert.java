import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> isHighTemp = temp -> temp > 37.5;
        double currentTemp = 38.2;
        if(isHighTemp.test(currentTemp)) {
            System.out.println("ALERT: High Temperature!");
        }
    }
}