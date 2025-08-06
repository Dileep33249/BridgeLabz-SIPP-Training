import java.io.*;

public class ImageByteArrayDemo {
    public static void main(String[] args) {
        String imagePath = "source.jpg";
        String imageOut = "copy.jpg";
        try {
            FileInputStream fis = new FileInputStream(imagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(imageOut);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fis.close();
            fos.close();
            baos.close();
            bais.close();
            System.out.println("Image copied using ByteArray streams.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
