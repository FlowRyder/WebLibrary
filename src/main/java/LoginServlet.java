import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
//@WebServlet("/library")
public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession(true);
        response.setContentType("text/html");

        String login = request.getParameter("user-login");
        String password = request.getParameter("user-password");


        Socket localhost = new Socket("localhost", 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        BufferedReader inputSystem = new BufferedReader(new InputStreamReader(System.in));
        output.println("log_in " + login + " " + password);
        String string = input.readLine();
        System.out.println(string);
        if(string.equals("1")) {
            RequestDispatcher rs = request.getRequestDispatcher("workshop.html");
            rs.forward(request, response);
        } else {
            RequestDispatcher rs = request.getRequestDispatcher("library.html");
            rs.forward(request, response);
        }
    }
}
