package hexlet.code.formats;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> list) {

        StringBuilder result = new StringBuilder();

        for (Map<String, Object> dif : list) {
            Object status = dif.get("status");
            if (status.equals("ADDED")) {
                result
                        .append("  + ")
                        .append(dif.get("key"))
                        .append(": ")
                        .append(dif.get("value"))
                        .append("\n");
            } else if (status.equals("REMOVED")) {
                result
                        .append("  - ")
                        .append(dif.get("key"))
                        .append(": ")
                        .append(dif.get("value"))
                        .append("\n");
            } else if (status.equals("UNCHANGED")) {
                result
                        .append("    ")
                        .append(dif.get("key"))
                        .append(": ")
                        .append(dif.get("value"))
                        .append("\n");
            } else if (status.equals("UPDATED")) {
                result
                        .append("  - ")
                        .append(dif.get("key"))
                        .append(": ")
                        .append(dif.get("value1"))
                        .append("\n")
                        .append("  + ")
                        .append(dif.get("key"))
                        .append(": ")
                        .append(dif.get("value2"))
                        .append("\n");
            }
        }
        return "{" + "\n" + result + "}";
    }
}
