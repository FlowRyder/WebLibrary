import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by FlowRyder.
 */
public class AddGenreServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SocketConnection.setConnection(request, response);
        ServletContext sessionServletContext = request.getSession().getServletContext();

        BufferedReader inputServer = (BufferedReader)
                sessionServletContext.getAttribute(SocketConnection.INPUT_STREAM);
        PrintWriter outputServer = (PrintWriter)
                sessionServletContext.getAttribute(SocketConnection.OUTPUT_STREAM);
        PrintWriter outputClient = response.getWriter();

        String genreName = request.getParameter("genreName");
        String serverRequest = "add_genre " + genreName;
        outputServer.println(serverRequest);
        String serverResponse = inputServer.readLine();
        outputClient.print(serverResponse);
    }
}
