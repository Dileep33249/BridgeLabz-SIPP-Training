import java.util.*;

public class InventoryManagementSystem {
    static class Item {
        String name;
        int id;
        int quantity;
        double price;
        Item next;

        Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
        }
    }

    Item head = null;

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos == 0) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    public void updateQuantityById(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByIdOrName(int id, String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.id == id || (name != null && temp.name.equalsIgnoreCase(name))) {
                System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private Item mergeSort(Item head, boolean asc, boolean byName) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, asc, byName);
        Item right = mergeSort(nextOfMiddle, asc, byName);
        return merge(left, right, asc, byName);
    }

    private Item merge(Item a, Item b, boolean asc, boolean byName) {
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (byName) {
            condition = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }
        if (condition) {
            a.next = merge(a.next, b, asc, byName);
            return a;
        } else {
            b.next = merge(a, b.next, asc, byName);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayAll() {
        Item temp = head;
        if (temp == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        while (temp != null) {
            System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addAtEnd("Keyboard", 101, 5, 1200);
        ims.addAtBeginning("Mouse", 102, 10, 500);
        ims.addAtPosition(1, "Monitor", 103, 3, 9000);

        System.out.println("--- Inventory ---");
        ims.displayAll();

        System.out.println("\n--- Update Quantity ---");
        ims.updateQuantityById(101, 8);
        ims.displayAll();

        System.out.println("\n--- Search by Name ---");
        ims.searchByIdOrName(-1, "Monitor");

        System.out.println("\n--- Remove Item ---");
        ims.removeById(102);
        ims.displayAll();

        System.out.println("\n--- Total Value ---");
        ims.calculateTotalValue();

        System.out.println("\n--- Sort by Name (Ascending) ---");
        ims.sortByName(true);
        ims.displayAll();

        System.out.println("\n--- Sort by Price (Descending) ---");
        ims.sortByPrice(false);
        ims.displayAll();
    }
}
