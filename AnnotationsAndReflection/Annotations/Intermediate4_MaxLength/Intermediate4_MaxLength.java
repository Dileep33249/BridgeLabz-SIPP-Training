import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    public String username;

    public User(String username) throws Exception {
        Field field = User.class.getDeclaredField("username");
        MaxLength maxLength = field.getAnnotation(MaxLength.class);
        if (maxLength != null && username.length() > maxLength.value()) {
            throw new IllegalArgumentException("Username exceeds max length!");
        }
        this.username = username;
    }
}

public class Intermediate4_MaxLength {
    public static void main(String[] args) throws Exception {
        User user = new User("JohnDoe");
        System.out.println("Username: " + user.username);
    }
}