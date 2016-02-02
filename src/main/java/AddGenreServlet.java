import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by FlowRyder.
 */
public class AddGenreServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String genreName = request.getParameter("genre-name");

        SocketConnection.output.println("add_genre " + genreName);
        String string = SocketConnection.input.readLine();
        RequestDispatcher rs = request.getRequestDispatcher("workshop.html");
        rs.forward(request, response);
    }
}
