import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final Logger logger = new Logger();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(NetworkConstants.DEFAULT_PORT))
        {
            logger.log("Сервер запущен на порту 8080");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new Thread(() -> handleClient(socket)).start();
                } catch (IOException e) {
                    logger.error("Ошибка принятии соединения", e);
                }
            }
        } catch (IOException e) {
            logger.error("Не удалось запустить сервер", e);
        }
    }

    public static void handleClient(Socket socket) {
        try (OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream()))
        {
            writer.write(StringConstants.OK_RESPONSE + "\n");
            writer.flush();
            logger.log("Выдан ответ клиенту");
        } catch (IOException e) {
            logger.error("Ошибка при отправке ответа клиенту", e);
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }

}
