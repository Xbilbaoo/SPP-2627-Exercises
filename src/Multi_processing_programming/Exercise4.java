package Multi_processing_programming;

import java.io.IOException;

public class Exercise4 {

    static void main() {

        try {

            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb0 = new ProcessBuilder("java", "-cp", classpath,
                    "Multi_processing_programming.examples.Sum", "1", "99999999");
            ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", classpath,
                    "Multi_processing_programming.examples.Sum", "1", "50000000");
            ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", classpath,
                    "Multi_processing_programming.examples.Sum", "50000001", "99999999");

            pb0.inheritIO();
            pb1.inheritIO();
            pb2.inheritIO();

            long startTime = System.currentTimeMillis();
            Process p0 = pb0.start();
            p0.waitFor();
            long endTime = System.currentTimeMillis();
            System.out.printf("1 Prozesua bukatu da denbora honekin: %f\n\n", ((endTime - startTime)/1000.0));

            startTime = System.currentTimeMillis();
            Process p1 = pb1.start();
            Process p2 = pb2.start();

            p1.waitFor();
            p2.waitFor();
            endTime = System.currentTimeMillis();
            System.out.printf("2 Prozesua bukatu da denbora honekin: %f", ((endTime - startTime)/1000.0));






        } catch (IOException | InterruptedException e) { e.printStackTrace(); }

    }

}
