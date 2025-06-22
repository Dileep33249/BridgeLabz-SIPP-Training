import java.util.Scanner;

public class VotingEligibility {

    public static int[] getStudentAges(int n) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18)
                result[i][1] = "true";
            else
                result[i][1] = "false";
        }
        return result;
    }

    public static void display(String[][] arr) {
        System.out.println("Age\tCan Vote");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter age of 10 students:");
        int[] ages = getStudentAges(10);
        String[][] result = checkVotingEligibility(ages);
        display(result);
    }
}
