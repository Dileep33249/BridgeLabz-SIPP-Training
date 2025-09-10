interface Sensitive {}

class BankDetails implements Sensitive {
    String accountNumber;
    BankDetails(String accountNumber) { this.accountNumber = accountNumber; }
    public String toString() { return "Bank Account: " + accountNumber; }
}

public class SensitiveDataTagging {
    public static void main(String[] args) {
        BankDetails bd = new BankDetails("1234-5678-9012");
        if(bd instanceof Sensitive) {
            System.out.println("Encrypting sensitive data: " + bd);
        }
    }
}