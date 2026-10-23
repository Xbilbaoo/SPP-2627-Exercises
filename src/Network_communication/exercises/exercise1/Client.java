package Network_communication.exercises.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Klase hau makina lokalean 5000 portuan entzuten dagoen zerbitzari batera
 * konektatzen da 'bezeroKopurua' aldiz, mezu bat bidaltzen dio
 * eta erantzuna itxaroten du.
 */
public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.36.96", 5000)) {
            // Sortu sarrera eta irteera Stream-ak
            PrintWriter irteera = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader sarrera = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Bidali mezua zerbitzariari
            irteera.println("Xabier");

            // Irakurri zerbitzariaren erantzuna
            String erantzuna = sarrera.readLine();
            System.out.println("Zerbitzariaren erantzuna: " + erantzuna);
            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
