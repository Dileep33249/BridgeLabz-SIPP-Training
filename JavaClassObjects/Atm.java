class Atm {
    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount(String holder, String number, double balance) {
        this.accountHolder = holder;
        this.accountNumber = number;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Dileep", "SBIN000123", 20000);
        account.deposit(5000);
        account.withdraw(3000);
        account.displayBalance();
    }
}
