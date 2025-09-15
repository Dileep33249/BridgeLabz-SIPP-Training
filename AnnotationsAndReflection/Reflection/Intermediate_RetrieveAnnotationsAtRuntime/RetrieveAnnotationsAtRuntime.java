import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class MyClass {
}

public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) {
        Class<MyClass> cls = MyClass.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}