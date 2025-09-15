import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Feature {
    @BugReport(description = "Null pointer exception on input")
    @BugReport(description = "Incorrect output format")
    public void testFeature() {
        System.out.println("Testing feature");
    }
}

public class Exercise5_CreateRepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = Feature.class.getMethod("testFeature");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}