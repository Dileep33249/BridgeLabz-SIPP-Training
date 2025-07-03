public class Bankaccount {
    static String bankName = "National Bank";
    static int totalAccounts = 0;
    final String accountNumber;
    String accountHolderName;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println(accountHolderName + " | " + accountNumber);
        }
    }
}
