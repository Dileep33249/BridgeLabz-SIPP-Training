import java.util.Random;

public class ZaraBonus {

    public static int[][] generateSalariesAndService(int n) {
        int[][] data = new int[n][2];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // salary
            data[i][1] = rand.nextInt(11); // years of service 0–10
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(int[][] data) {
        double[][] result = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double bonus = (data[i][1] > 5) ? 0.05 * data[i][0] : 0.02 * data[i][0];
            result[i][0] = bonus;
            result[i][1] = data[i][0] + bonus;
        }
        return result;
    }

    public static void displayTable(int[][] oldData, double[][] newData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.printf("%-10s%-15s%-15s%-15s%-15s\n", "Emp", "OldSalary", "ServiceYrs", "Bonus", "NewSalary");

        for (int i = 0; i < oldData.length; i++) {
            totalOld += oldData[i][0];
            totalNew += newData[i][1];
            totalBonus += newData[i][0];
            System.out.printf("%-10d%-15d%-15d%-15.2f%-15.2f\n", i + 1, oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
        }

        System.out.println("\nTotal Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
        System.out.println("Total Bonus Paid: " + totalBonus);
    }

    public static void main(String[] args) {
        int[][] employeeData = generateSalariesAndService(10);
        double[][] bonuses = calculateBonusAndNewSalary(employeeData);
        displayTable(employeeData, bonuses);
    }
}
