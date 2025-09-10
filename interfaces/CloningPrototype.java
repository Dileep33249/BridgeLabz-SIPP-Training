class Prototype implements Cloneable {
    String data;
    Prototype(String data) { this.data = data; }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() { return "Prototype: " + data; }
}

public class CloningPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype("Model1");
        Prototype p2 = (Prototype) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
    }
}