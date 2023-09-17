package hexlet.code.formats;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String makeStylish(List<Map<String, Object>> list) {
        String result = "";

        for (Map<String, Object> dif : list) {
            Object status = dif.get("status");
            if (status.equals("ADDED")) {
                result = result + "  + " + dif.get("key") + ": " + dif.get("value") + "\n";
            } else if (status.equals("REMOVED")) {
                result = result + "  - " + dif.get("key") + ": " + dif.get("value") + "\n";
            } else if (status.equals("UNCHANGED")) {
                result = result + "    " + dif.get("key") + ": " + dif.get("value") + "\n";
            } else if (status.equals("UPDATED")) {
                result = result + "  - " + dif.get("key") + ": " + dif.get("value1") + "\n"
                        + "  + " + dif.get("key") + ": " + dif.get("value2") + "\n";
            }
        }
        return "{" + "\n" + result + "}";
    }
}
