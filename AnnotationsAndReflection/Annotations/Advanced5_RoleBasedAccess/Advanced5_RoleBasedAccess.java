import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void secureAction() {
        System.out.println("Admin action executed");
    }
}

public class Advanced5_RoleBasedAccess {
    public static void main(String[] args) throws Exception {
        String currentRole = "USER";
        AdminService service = new AdminService();
        Method method = AdminService.class.getMethod("secureAction");
        RoleAllowed allowed = method.getAnnotation(RoleAllowed.class);
        if (allowed != null && allowed.value().equals(currentRole)) {
            method.invoke(service);
        } else {
            System.out.println("Access Denied!");
        }
    }
}