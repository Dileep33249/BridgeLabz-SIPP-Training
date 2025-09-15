import java.util.*;

public class Exercise3_SuppressWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        for (Object obj : list) {
            System.out.println((String)obj);
        }
    }
}