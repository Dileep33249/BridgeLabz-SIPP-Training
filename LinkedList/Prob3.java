public class TaskScheduler {
    static class Task {
        int id;
        String name;
        int priority;
        String dueDate;
        Task next;

        Task(int id, String name, int priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    Task head = null;
    Task current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = current = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            head = newTask;
            temp.next = head;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = current = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 0) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            if (head.next == head) {
                head = current = null;
                return;
            }
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            head = head.next;
            temp.next = head;
            return;
        }
        Task temp = head;
        while (temp.next != head && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next.id == id) {
            if (temp.next == current) current = current.next;
            temp.next = temp.next.next;
        }
    }

    public void viewCurrentAndMoveNext() {
        if (current == null) return;
        System.out.println("Task ID: " + current.id + ", Name: " + current.name + ", Priority: " + current.priority + ", Due: " + current.dueDate);
        current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.id + ", Name: " + temp.name + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.id + ", Name: " + temp.name + ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No task with priority " + priority);
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        ts.addAtEnd(1, "Write report", 2, "2025-07-15");
        ts.addAtBeginning(2, "Email team", 1, "2025-07-14");
        ts.addAtPosition(1, 3, "Prepare slides", 3, "2025-07-20");

        System.out.println("--- All Tasks ---");
        ts.displayAllTasks();

        System.out.println("\n--- View Current Task and Move ---");
        ts.viewCurrentAndMoveNext();
        ts.viewCurrentAndMoveNext();

        System.out.println("\n--- Search by Priority 3 ---");
        ts.searchByPriority(3);

        System.out.println("\n--- Remove Task with ID 2 ---");
        ts.removeById(2);
        ts.displayAllTasks();
    }
}
