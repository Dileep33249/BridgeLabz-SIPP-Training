import java.util.*;

public class RoundRobinScheduler {
    static class Process {
        int id;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime;
        int turnAroundTime;
        Process next;

        Process(int id, int burstTime, int priority) {
            this.id = id;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    Process head = null;

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcess(int id) {
        if (head == null) return;

        if (head.id == id && head.next == head) {
            head = null;
            return;
        }

        Process curr = head, prev = null;

        do {
            if (curr.id == id) {
                if (curr == head) {
                    Process temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Remaining: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void simulate(int timeQuantum) {
        if (head == null) return;

        Queue<Process> completed = new LinkedList<>();
        int time = 0;
        Process curr = head;

        while (head != null) {
            if (curr.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, curr.remainingTime);
                curr.remainingTime -= execTime;
                time += execTime;
                if (curr.remainingTime == 0) {
                    curr.turnAroundTime = time;
                    curr.waitingTime = curr.turnAroundTime - curr.burstTime;
                    completed.add(curr);
                    removeProcess(curr.id);
                    curr = head;
                    continue;
                }
            }
            curr = curr.next;
        }

        System.out.println("\n--- Completion Info ---");
        int totalWT = 0, totalTAT = 0;
        int n = completed.size();
        while (!completed.isEmpty()) {
            Process p = completed.poll();
            System.out.println("Process " + p.id + " -> WT: " + p.waitingTime + ", TAT: " + p.turnAroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnAroundTime;
        }
        System.out.printf("Average Waiting Time: %.2f\n", (double) totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTAT / n);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        System.out.println("--- Initial Process Queue ---");
        scheduler.displayProcesses();

        scheduler.simulate(4);
    }
}
