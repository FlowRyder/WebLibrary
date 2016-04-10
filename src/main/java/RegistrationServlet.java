import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SocketConnection.setConnection(request, response);
        ServletContext sessionServletContext = request.getSession().getServletContext();

        BufferedReader inputServer = (BufferedReader)
                sessionServletContext.getAttribute(SocketConnection.INPUT_STREAM);
        PrintWriter outputServer = (PrintWriter)
                sessionServletContext.getAttribute(SocketConnection.OUTPUT_STREAM);
        PrintWriter outputClient = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String serverRequest = "register " + name + " " + login + " " + email + " " + password + " reader";
        outputServer.println(serverRequest);
        String serverResponse = inputServer.readLine();

        if (serverResponse.equals("0")) {
            outputClient.print("Success");
        } else {
            outputClient.print("Wrong login or password");
        }
    }
}
