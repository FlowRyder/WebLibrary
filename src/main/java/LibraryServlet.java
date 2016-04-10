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
public class LibraryServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SocketConnection.setConnection(request, response);
        ServletContext sessionServletContext = request.getSession().getServletContext();
        String login = (String) sessionServletContext.getAttribute("login");

        BufferedReader inputServer = (BufferedReader)
                sessionServletContext.getAttribute(SocketConnection.INPUT_STREAM);
        PrintWriter outputServer = (PrintWriter)
                sessionServletContext.getAttribute(SocketConnection.OUTPUT_STREAM);

        String serverRequest = "find_by_login " + login;
        outputServer.println(serverRequest);
        String readerID = inputServer.readLine();

        String bookName = request.getParameter("book_name");
        serverRequest = "find_by_book " + bookName;
        outputServer.println(serverRequest);
        String bookID = inputServer.readLine();

        String issueDay = request.getParameter("issueDay");
        String issueMonth = request.getParameter("issueMonth");
        String issueYear = request.getParameter("issueYear");

        String returnDay = request.getParameter("returnDay");
        String returnMonth = request.getParameter("returnMonth");
        String returnYear = request.getParameter("returnYear");

        serverRequest = "add_account" + readerID + " " + bookID + " " + issueDay + " " + issueMonth + " " + issueYear +
                " " + returnDay + " " + returnMonth + " " + returnYear;

        outputServer.println(serverRequest);

    }
}
