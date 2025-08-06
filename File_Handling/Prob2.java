import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String source = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destNormal = "copy_normal.dat";
        long start, end;
        try {
            start = System.nanoTime();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered));
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bis.close();
            bos.close();
            end = System.nanoTime();
            System.out.println("Buffered streams time: " + (end - start)/1_000_000 + " ms");

            start = System.nanoTime();
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destNormal);
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fis.close();
            fos.close();
            end = System.nanoTime();
            System.out.println("Unbuffered streams time: " + (end - start)/1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
