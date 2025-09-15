import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void performTask() {
        System.out.println("Task is being performed");
    }
}

public class Exercise4_CreateCustomAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("performTask");
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo info = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }
    }
}