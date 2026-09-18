package Multi_processing_programming.examples;

import java.io.IOException;

public class SumInitializer {

   static void main(String[] args) {

       try {

           String classpath = System.getProperty("java.class.path");

           ProcessBuilder processBuilder_1 = new ProcessBuilder("java", "-cp", classpath,
                               "Multi_processing_programming.examples.Sum", "6", "10");

           processBuilder_1.inheritIO();

           Process process_1 = processBuilder_1.start();

           int exitCode_1 = process_1.waitFor();
           System.out.println("\n 1 Prozesua bukatu da irteera kode honekin: " + exitCode_1);

       } catch (IOException | InterruptedException e) { e.printStackTrace(); }

   }

}
