import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalCost() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> cart = new ArrayList<>();

    void addItem(String name, double price, int qty) {
        cart.add(new CartItem(name, price, qty));
    }

    void removeItem(String name) {
        cart.removeIf(item -> item.itemName.equalsIgnoreCase(name));
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalCost();
        }
        System.out.println("Total Cart Cost: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addItem("Laptop", 55000, 1);
        sc.addItem("Mouse", 500, 2);
        sc.displayTotalCost();
        sc.removeItem("Mouse");
        sc.displayTotalCost();
    }
}
