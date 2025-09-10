public class BackgroundJobExecution {
    public static void main(String[] args) {
        Runnable job = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Background job executed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(job).start();
    }
}