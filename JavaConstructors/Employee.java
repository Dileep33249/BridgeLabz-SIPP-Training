public class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public void updateSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public void showInfo() {
        System.out.println(employeeID + " - " + department);
    }
}
