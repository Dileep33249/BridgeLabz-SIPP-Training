import java.lang.reflect.*;

class Person {
    private int age = 30;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        System.out.println("Original age: " + field.getInt(person));

        field.setInt(person, 40);

        System.out.println("Modified age: " + field.getInt(person));
    }
}