import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 3500;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Servidor escutando na porta: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}