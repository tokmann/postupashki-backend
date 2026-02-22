import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    private static final Logger logger = new Logger();

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(NetworkConstants.DEFAULT_HOST, NetworkConstants.DEFAULT_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            logger.log("Клиент запущен");

            String response = reader.readLine();
            if (StringConstants.OK_RESPONSE.equals(response)) logger.log("Принят корректный ответ от сервера");
            else logger.log("Некорректный ответ от сервера");
        } catch (IOException e) {
            logger.error("Ошибка при подключении к серверу", e);
        }
    }
}
