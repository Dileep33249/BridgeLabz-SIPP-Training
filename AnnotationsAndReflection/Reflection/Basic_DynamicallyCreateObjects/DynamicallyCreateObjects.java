import java.lang.reflect.*;

class Student {
    String name = "John Doe";
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Constructor<?> constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true);

        Student student = (Student) constructor.newInstance();
        System.out.println("Student name: " + student.name);
    }
}