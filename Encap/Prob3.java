abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.holderName = name;
        this.balance = balance;
    }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(int acc, String name, double bal) {
        super(acc, name, bal);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}
