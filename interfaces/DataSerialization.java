interface BackupSerializable {}

class UserData implements BackupSerializable {
    String name;
    UserData(String name) { this.name = name; }
    public String toString() { return "UserData: " + name; }
}

public class DataSerialization {
    public static void main(String[] args) {
        UserData user = new UserData("Alice");
        if(user instanceof BackupSerializable) {
            System.out.println("Ready for backup: " + user);
        }
    }
}