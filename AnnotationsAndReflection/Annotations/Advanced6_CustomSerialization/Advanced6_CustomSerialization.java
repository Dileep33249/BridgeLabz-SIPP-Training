import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    public String username = "john_doe";
    @JsonField(name = "user_age")
    public int age = 30;
}

public class Advanced6_CustomSerialization {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        int count = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jf = field.getAnnotation(JsonField.class);
                if (count > 0) sb.append(", ");
                sb.append("\"" + jf.name() + "\": \"" + field.get(obj) + "\"");
                count++;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        System.out.println(toJson(user));
    }
}