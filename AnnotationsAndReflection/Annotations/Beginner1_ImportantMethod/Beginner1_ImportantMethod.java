import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Work {
    @ImportantMethod
    public void firstTask() {
        System.out.println("First important task");
    }

    @ImportantMethod(level = "MEDIUM")
    public void secondTask() {
        System.out.println("Second important task");
    }
}

public class Beginner1_ImportantMethod {
    public static void main(String[] args) throws Exception {
        for (Method method : Work.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + im.level());
            }
        }
    }
}