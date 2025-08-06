import java.io.*;

public class UpperToLowerFile {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            br.close();
            bw.close();
            System.out.println("Uppercase letters converted to lowercase.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
