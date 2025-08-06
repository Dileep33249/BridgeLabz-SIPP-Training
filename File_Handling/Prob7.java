import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filename = "students.dat";
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeInt(101);
            dos.writeUTF("John");
            dos.writeDouble(8.6);
            dos.writeInt(102);
            dos.writeUTF("Aria");
            dos.writeDouble(9.1);
            dos.close();
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println(roll + " " + name + " " + gpa);
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
