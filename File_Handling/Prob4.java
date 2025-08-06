import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String dept;
    double salary;
    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    public String toString() {
        return id + " " + name + " " + dept + " " + salary;
    }
}

public class EmployeeSerializeDemo {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Alice", "HR", 40000));
        empList.add(new Employee(2, "Bob", "IT", 45000));
        empList.add(new Employee(3, "Sara", "Marketing", 42000));
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"));
            oos.writeObject(empList);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));
            List<Employee> readList = (List<Employee>) ois.readObject();
            ois.close();
            for (Employee e : readList) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
