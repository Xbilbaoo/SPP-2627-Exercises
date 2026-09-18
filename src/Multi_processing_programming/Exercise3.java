package Multi_processing_programming;

import java.io.IOException;
import java.util.ArrayList;

public class Exercise3 {

    static void main(String[] args) {

        checkInput(args);

        String[] sleepTimes = importArgs(args);

        if (sleepTimes != null) {

            calculateProcessingTimes(sleepTimes);

        }


    }

    private static void calculateProcessingTimes(String[] sleepTimes) {

        ArrayList<Process> processes = new ArrayList<>();
        for (String sleepTime : sleepTimes) {

            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"),
                    "Multi_processing_programming.ProcessCreator", sleepTime);

            pb.inheritIO();

            try {

                Process process = pb.start();

            } catch (IOException e) { e.printStackTrace(); }


        }
    }

    private static String[] importArgs(String[] args) {

        if (args == null || args.length == 0) {
            System.out.println("Ez duzu parametrorik sartu.");
            return null;
        }

        return args[0].split(",");

    }

    private static void checkInput(String[] args) {

        for (String arg : args) {

            System.out.println(arg);

        }
    }
}
