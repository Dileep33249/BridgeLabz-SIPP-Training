import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 1200),
            new Claim("Auto", 800),
            new Claim("Health", 2000),
            new Claim("Auto", 1500),
            new Claim("Life", 5000)
        );

        Map<String, Double> avgClaims = claims.stream()
            .collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)));

        avgClaims.forEach((type, avg) -> System.out.println(type + " Average: " + avg));
    }
}