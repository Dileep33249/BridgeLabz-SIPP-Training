import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "hello world hello java world java hello";
        String[] words = paragraph.split(" ");

        Map<String, Long> frequency = Arrays.stream(words)
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(frequency);
    }
}