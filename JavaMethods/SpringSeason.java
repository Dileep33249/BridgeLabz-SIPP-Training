public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || 
               (month > 3 && month < 6) ||
               (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        int month = 4, day = 15;
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
