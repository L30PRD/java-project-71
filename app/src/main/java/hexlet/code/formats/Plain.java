package hexlet.code.formats;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
                        .append(collectionCheck(dif.get("value")))
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
                        .append(collectionCheck(dif.get("value1")))
                        .append(" to ")
                        .append(collectionCheck(dif.get("value2")))
                        .append("\n");
            }
        }
        return result.toString().trim();
    }


    public static Object collectionCheck(Object obj) {
        if(Objects.isNull(obj)) {
            return "null";
        }
        Object str = obj instanceof String ? "'" + obj + "'" : obj;
        return str instanceof Arrays || str instanceof List || str instanceof Map<?, ?>
                ? "[complex value]" : str;
    }
}
