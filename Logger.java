
public class Logger {

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    public void error(String message, Exception e) {
        System.out.println("LOG: " + message);
        System.out.println(e.toString());
    }
}
