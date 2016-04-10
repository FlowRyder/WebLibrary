import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder.
 */
public class SocketConnection {

    public static final String INPUT_STREAM = "INPUT_STREAM";
    public static final String OUTPUT_STREAM = "OUTPUT_STREAM";
    public static final String LOCALHOST = "LOCALHOST";


    public static void setConnection(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        Socket socket = (Socket) session.getServletContext().getAttribute(LOCALHOST);

        if (socket == null || socket.isClosed()) {
            socket = new Socket("localhost", 4444);
            session.getServletContext().setAttribute(INPUT_STREAM, new BufferedReader(new InputStreamReader(socket.getInputStream())));
            session.getServletContext().setAttribute(OUTPUT_STREAM, new PrintWriter(socket.getOutputStream(), true));
            session.getServletContext().setAttribute(LOCALHOST, socket);
        }

    }

}
