import java.lang.reflect.*;

public class GetClassInformation {
    public static void main(String[] args) throws Exception {
        String className = "java.util.ArrayList"; // You can change this or accept input
        Class<?> cls = Class.forName(className);

        System.out.println("Class: " + cls.getName());

        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
    }
}