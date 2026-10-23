package Network_communication.exercises.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManager implements Runnable {


    private final Socket socket;

    public ClientManager(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String mezua = "";
        try {
            System.out.println("Bezeroa konektatu da: " + socket.getInetAddress().getHostAddress());

            BufferedReader sarrera = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter irteera = new PrintWriter(socket.getOutputStream(), true);

            // Leer el nombre del usuario ("Xabier")
            mezua = sarrera.readLine();
            System.out.println("Bezerotik jasotako mezua: " + mezua);

            // AÑADIR A LA LISTA de forma segura
            synchronized (Server.usuariosConectados) {
                Server.usuariosConectados.add(mezua);
            }

            // Responder al cliente
            irteera.println("Ongi etorri, " + mezua);

            // IMPORTANTE: Mantenemos el hilo vivo leyendo.
            // Mientras el cliente mantenga el socket abierto, readLine() bloqueará aquí.
            // Cuando el cliente se desconecte (pase su sleep de 100 seg), readLine devolverá null.
            while (sarrera.readLine() != null) {
                // Esperando activamente a la desconexión
            }

        } catch (IOException e) {
            // Maneja si el cliente se cierra de golpe
        } finally {
            // QUITAR DE LA LISTA al desconectarse y cerrar el socket
            synchronized (Server.usuariosConectados) {
                Server.usuariosConectados.remove(mezua);
            }
            System.out.println("Bezeroa deskonektatu da: " + mezua);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
