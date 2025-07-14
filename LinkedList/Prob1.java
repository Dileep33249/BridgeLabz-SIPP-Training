public class StudentRecordManagement {
    static class Student {
        int rollNumber;
        String name;
        int age;
        char grade;
        Student next;

        Student(int rollNumber, String name, int age, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    Student head = null;

    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int pos, int roll, String name, int age, char grade) {
        if (pos == 0) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public Student searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int roll, char newGrade) {
        Student student = searchByRollNumber(roll);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    public void displayRecords() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No student records.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();

        list.addAtBeginning(1, "Alice", 20, 'A');
        list.addAtEnd(2, "Bob", 22, 'B');
        list.addAtPosition(1, 3, "Charlie", 21, 'C');

        System.out.println("All Records:");
        list.displayRecords();

        System.out.println("\nUpdating Grade for Roll 2 to A...");
        list.updateGrade(2, 'A');

        System.out.println("Searching Roll 3...");
        Student s = list.searchByRollNumber(3);
        if (s != null) {
            System.out.println("Found: " + s.name);
        }

        System.out.println("\nDeleting Roll 1...");
        list.deleteByRollNumber(1);

        System.out.println("Final Records:");
        list.displayRecords();
    }
}
