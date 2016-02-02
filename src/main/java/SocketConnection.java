import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder.
 */
public class SocketConnection {
    static Socket localhost;
    static BufferedReader input;
    static PrintWriter output;

    static {
        try {
            localhost = new Socket("localhost", 4444);
            input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
            output = new PrintWriter(localhost.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
