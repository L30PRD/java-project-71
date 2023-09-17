package hexlet.code.formats;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String plain(List<Map<String, Object>> list) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> dif : list) {
            Object status = dif.get("status");
            if (status.equals("ADDED")) {
                result
                        .append("Property '")
                        .append(dif.get("key"))
                        .append("' was added with value: ")
                        .append(stringCheck(dif.get("new_value")))
                        .append("\n");
            } else if (status.equals("REMOVED")) {
                result
                        .append("Property '")
                        .append(dif.get("key"))
                        .append("' was removed")
                        .append("\n");
            } else if (status.equals("UPDATED")) {
                result
                        .append("Property '")
                        .append(dif.get("key"))
                        .append("' was updated. From ")
                        .append(stringCheck(dif.get("old_value")))
                        .append(" to ")
                        .append(stringCheck(dif.get("new_value")))
                        .append("\n");
            }
        }
        return result.toString();
    }


    public static Object stringCheck(Object obj) {
        return obj instanceof Arrays || obj instanceof List || obj instanceof Map<?, ?>
                ? "[complex value]" : obj;
    }
}
