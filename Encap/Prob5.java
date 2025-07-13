abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String name, double price, int quantity) {
        this.itemName = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();
    public void getItemDetails() {
        System.out.println(itemName + " x " + quantity);
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return (price * quantity) - applyDiscount();
    }

    public double applyDiscount() { return 5; }

    public String getDiscountDetails() { return "Flat ₹5 off on Veg item"; }
}
