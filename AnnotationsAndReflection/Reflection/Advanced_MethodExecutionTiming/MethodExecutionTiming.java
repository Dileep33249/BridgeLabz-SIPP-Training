import java.lang.reflect.*;

class Task {
    public void perform() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Task performed.");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("perform");

        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();

        System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    }
}