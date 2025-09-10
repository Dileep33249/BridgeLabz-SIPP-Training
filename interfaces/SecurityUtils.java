interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") && password.matches(".*[0-9].*");
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Weak123"));
        System.out.println(SecurityUtils.isStrongPassword("StrongPass1"));
    }
}