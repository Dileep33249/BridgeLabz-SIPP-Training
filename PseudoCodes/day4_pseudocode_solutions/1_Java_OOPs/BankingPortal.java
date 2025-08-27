
// Pseudocode for Banking Portal
class Account {
    balance;
    deposit(amount);
    withdraw(amount); // to be overridden
}

class SavingAccount extends Account {
    withdraw(amount) {
        if (balance - amount >= 500) {
            balance -= amount;
        } else {
            print("Minimum balance must be 500");
        }
    }
}

class CurrentAccount extends Account {
    withdraw(amount) {
        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            print("Overdraft not allowed");
        }
    }
}
