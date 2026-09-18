package Multi_processing_programming;

public class ProcessCreator {

    public static void main(String[] args) {
        if (args.length == 0) return;

        long pid = ProcessHandle.current().pid();
        int seconds = Integer.parseInt(args[0]);

        System.out.println("Prozesua HASI da (PID: " + pid + ") - " + seconds + " segundu itxarongo ditu.");

        try {

            Thread.sleep(seconds * 1000L);

        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Prozesua BUKATU da (PID: " + pid + ")");
    }
}
