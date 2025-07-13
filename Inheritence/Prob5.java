class Order {
    int orderId;

    Order(int id) {
        this.orderId = id;
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int id, String trackingNumber) {
        super(id);
        this.trackingNumber = trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int id, String trackingNumber, String date) {
        super(id, trackingNumber);
        this.deliveryDate = date;
    }

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId + ", Delivered on: " + deliveryDate);
    }
}
