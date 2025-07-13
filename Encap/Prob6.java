abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.patientId = id;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.println("Patient: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int days;
    private String records = "";

    public InPatient(int id, String name, int age, double rate, int days) {
        super(id, name, age);
        this.dailyRate = rate;
        this.days = days;
    }

    public double calculateBill() {
        return dailyRate * days;
    }

    public void addRecord(String record) {
        records += record + "\n";
    }

    public String viewRecords() {
        return records;
    }
}
