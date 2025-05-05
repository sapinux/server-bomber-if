import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ClientHandler extends Thread{
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();

            byte[] buffer = new byte[1024];
            int bytes;

            while ((bytes = inputStream.read(buffer)) != -1) {
                String mensagem = new String(buffer, 1, bytes, StandardCharsets.UTF_8);

                System.out.println(mensagem);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
