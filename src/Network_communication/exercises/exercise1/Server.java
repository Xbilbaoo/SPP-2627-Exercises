package Network_communication.exercises.exercise1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {


    public static ArrayList<String> usuariosConectados = new ArrayList<>();

    static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000); // Espera 5 segundos

                        // Bloqueamos la lista mientras la leemos para que sea seguro
                        synchronized (usuariosConectados) {
                            System.out.println("\n--- KONEKTATUTAKO ERABILTZAILEAK ---");
                            for (String usuario : usuariosConectados) {
                                System.out.println("- " + usuario);
                            }
                            System.out.println("------------------------------------\n");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // BUCLE PRINCIPAL: Acepta clientes
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Zerbitzaria 5000 portuan entzuten...");

            while (true) {
                Socket socket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(socket);
                new Thread(clientManager).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
