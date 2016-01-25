import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder.
 */
//@WebServlet("/library")
public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession(true);
        response.setContentType("text/html");

        String login = request.getParameter("user-login");
        String password = request.getParameter("user-password");

        Socket localhost = new Socket("localhost", 4444);
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        output.println("log_in " + login + " " + password);
    }
}
