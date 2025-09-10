import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(101.5, 102.8, 99.9, 104.2);
        prices.forEach(System.out::println);
    }
}