package hexlet.code.formats;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {

    public static String makePlain(List<Map<String, Object>> list) {
        String result = "";

        for (Map<String, Object> dif : list) {
            Object status = dif.get("status");
            if (status.equals("ADDED")) {
                result = result + "Property '" + dif.get("key") + "' was added with value: "
                        + collectionCheck(dif.get("value")) + "\n";
            } else if (status.equals("REMOVED")) {
                result = result + "Property '" + dif.get("key") + "' was removed" + "\n";
            } else if (status.equals("UPDATED")) {
                result = result + "Property '" + dif.get("key") + "' was updated. From "
                        + collectionCheck(dif.get("value1")) + " to " + collectionCheck(dif.get("value2")) + "\n";
            }
        }
        return result.trim();
    }

    private static Object collectionCheck(Object obj) {
        if (Objects.isNull(obj)) {
            return "null";
        } else if (obj instanceof String) {
            return "'" + obj + "'";
        } else if (obj instanceof Arrays || obj instanceof List || obj instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return obj.toString();
        }
    }
}
