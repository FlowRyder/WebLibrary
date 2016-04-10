import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by FlowRyder.
 */
public class EditGenreServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /*SocketConnection.output.println("load_genres");
        String string1 = SocketConnection.input.readLine();*/
        //out.println("<html><body>" + string1 + "</body></html>");
        /*HashMap<String, String> genres = Parser.getNamedObjectMap(string1);
        out.println("<html><body>");
        out.println("<select>");
        for (String string : genres.values()) {
            out.println("<option>" + string + "</option>");
        }
        out.println("</select>");
        out.println("</body></html>");*/
    }
}
