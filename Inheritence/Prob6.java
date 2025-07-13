class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int acc, double bal) {
        this.accountNumber = acc;
        this.balance = bal;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int acc, double bal, double rate) {
        super(acc, bal);
        this.interestRate = rate;
    }

    void displayAccountType() {
        System.out.println("Savings Account with interest: " + interestRate);
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(int acc, double bal, double limit) {
        super(acc, bal);
        this.withdrawalLimit = limit;
    }

    void displayAccountType() {
        System.out.println("Checking Account with limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int tenure;

    FixedDepositAccount(int acc, double bal, int tenure) {
        super(acc, bal);
        this.tenure = tenure;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit for: " + tenure + " months");
    }
}
