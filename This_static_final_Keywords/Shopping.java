public class Shopping {
    static double discount = 10.0;
    final int productID;
    String productName;
    double price;
    int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println(productID + " | " + productName + " | " + price + " | " + quantity);
        }
    }
}
