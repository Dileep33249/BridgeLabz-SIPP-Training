import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveOperations {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int compute(int x) {
        if (cache.containsKey(x)) {
            System.out.println("Returning cached result for " + x);
            return cache.get(x);
        }
        System.out.println("Computing result for " + x);
        int result = x * x; // Simulate expensive computation
        cache.put(x, result);
        return result;
    }
}

public class Advanced7_CustomCaching {
    public static void main(String[] args) {
        ExpensiveOperations ops = new ExpensiveOperations();
        System.out.println(ops.compute(5));
        System.out.println(ops.compute(5));
    }
}