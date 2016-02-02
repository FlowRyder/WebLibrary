import java.util.HashMap;

/**
 * Created by FlowRyder.
 */
public class Parser {

    public static HashMap<String,String> getNamedObjectMap(String sourceString) {
        HashMap<String, String> result = new HashMap<String, String>();
        String[] namedObjectInfo = sourceString.split(",");
        for (String string : namedObjectInfo) {
            if (string.charAt(0) == ' ') {
                if (string.charAt(string.length()- 1) == ']') {
                    String newString = string.substring(0, string.length() - 1);
                    String[] namedObjectParameters = newString.split(" ");
                    result.put(namedObjectParameters[2], namedObjectParameters[1]);
                } else {
                    String[] namedObjectParameters = string.split(" ");
                    result.put(namedObjectParameters[2], namedObjectParameters[1]);
                }
            } else {
                if (string.charAt(0) == '[') {
                    String newString = string.substring(1, string.length());
                    String[] namedObjectParameters = newString.split(" ");
                    result.put(namedObjectParameters[1], namedObjectParameters[0]);
                } else {
                    String[] namedObjectParameters = string.split(" ");
                    result.put(namedObjectParameters[1], namedObjectParameters[0]);
                }
            }
        }
        return result;
    }
}
