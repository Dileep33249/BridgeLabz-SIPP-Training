abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Similar implementations for Clothing and Groceries...

static void printFinalPrice(Product p) {
    double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
    double finalPrice = p.getPrice() + tax - p.calculateDiscount();
    System.out.println(p.getName() + " Final Price: " + finalPrice);
}
