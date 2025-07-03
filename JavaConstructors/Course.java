public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println(courseName + " | " + duration + " weeks | " + fee);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }
}
