import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by FlowRyder.
 */
public class ConnectionResult {

    public static void write(String serverRequest, String serverResponse) {
        File file = new File("C:\\Users\\FlowRyder\\Desktop\\TEST\\result.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.println("Server request is " + serverRequest);
                out.println("Server response is " + serverResponse);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
