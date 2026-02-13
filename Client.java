import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8080);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Клиент запущен");

            String response = reader.readLine();
            if (response.equals("OK")) System.out.println("Принят корректный ответ от сервера");
            else System.out.println("Некорректный ответ от сервера");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
