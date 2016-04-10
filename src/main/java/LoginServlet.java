import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by FlowRyder.
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SocketConnection.setConnection(request, response);
        ServletContext sessionServletContext = request.getSession().getServletContext();

        BufferedReader inputServer = (BufferedReader)
                sessionServletContext.getAttribute(SocketConnection.INPUT_STREAM);
        PrintWriter outputServer = (PrintWriter)
                sessionServletContext.getAttribute(SocketConnection.OUTPUT_STREAM);
        PrintWriter outputClient = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String serverRequest = "log_in " + login + " " + password;
        outputServer.println(serverRequest);
        String serverResponse = inputServer.readLine();

        if (serverResponse.equals("0") || serverResponse.equals("1")) {
            outputClient.print("Success");
            outputClient.close();
            response.setStatus(HttpServletResponse.SC_OK);
            sessionServletContext.setAttribute("login", login);
            if (serverResponse.equals("0")) {
                response.sendRedirect("library.html");
            } else {
                response.sendRedirect("workshop.html");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            outputClient.print("Wrong login or password");
            outputClient.close();
            response.sendRedirect("welcome.html");
        }

        ConnectionResult.write(serverRequest, serverResponse);

    }
}
