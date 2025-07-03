public class Employee {
    static String companyName = "TechCorp";
    static int totalEmployees = 0;
    final int id;
    String name;
    String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println(name + " | " + id + " | " + designation);
        }
    }
}
