import java.lang.reflect.*;
import java.util.*;

class Person {
    public String name;
    public int age;
}

public class CreateCustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", 25);

        Person person = toObject(Person.class, props);
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
    }
}