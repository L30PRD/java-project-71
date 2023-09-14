package hexlet.code;

import java.io.IOException;
import java.util.List;

public class Formatter {

    public static String stylish(List<Difference> list) {
        StringBuilder result = new StringBuilder();

        for (Difference dif : list) {
            switch (dif.getStatus()) {
                case "ADDED" -> result
                        .append("  + ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject1())
                        .append("\n");
                case "REMOVED" -> result
                        .append("  - ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject1())
                        .append("\n");
                case "UNCHANGED" -> result
                        .append("    ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject1())
                        .append("\n");
                case "UPDATED" -> result
                        .append("  + ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject1())
                        .append("\n")
                        .append("  + ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject2())
                        .append("\n");
                default -> result.append("");
            }
        }
        return "{" + "\n" + result + "}";
    }

    public static String json(List<Difference> list) throws IOException {
        StringBuilder result = new StringBuilder();

        for (Difference dif : list) {
            switch (dif.getStatus()) {
                case "ADDED" -> result
                        .append("{")
                        .append("\"status\":\"+\",")
                        .append("\"name\":\"")
                        .append(dif.getName())
                        .append("\",")
                        .append("\"object1\":")
                        .append(dif.getObject1().toString())
                        .append("}");
                case "REMOVED" -> result
                        .append("{")
                        .append("\"status\":\"-\",")
                        .append("\"name\"\"")
                        .append(dif.getName())
                        .append("\",")
                        .append("\"object1\":")
                        .append(dif.getObject1().toString())
                        .append("}");
                case "UNCHANGED" -> result
                        .append("{")
                        .append("\"status\":\"    \",")
                        .append("\"name\":\"")
                        .append(dif.getName())
                        .append("\",")
                        .append("\"object1\":")
                        .append(dif.getObject1().toString())
                        .append("}");
                case "UPDATED" -> result
                        .append("{")
                        .append("\"status\":\"+\",")
                        .append("\"name\":\"")
                        .append(dif.getName())
                        .append("\",")
                        .append("\"object1\":")
                        .append(dif.getObject1().toString())
                        .append(",\"object2\":")
                        .append(dif.getObject2().toString())
                        .append("}");
                default -> result.append("");
            }
        }
        return "[" + result + "]";
    }

    public static String plain(List<Difference> list) {
        StringBuilder result = new StringBuilder();

        for (Difference dif : list) {
            switch (dif.getStatus()) {
                case "ADDED" -> result
                        .append("Property '")
                        .append(dif.getName())
                        .append("' was added with value: '")
                        .append(dif.getObject1())
                        .append("'\n");
                case "REMOVED" -> result
                        .append("Property '")
                        .append(dif.getName())
                        .append("' was removed")
                        .append("\n");
                case "UPDATED" -> result
                        .append("Property '")
                        .append(dif.getName())
                        .append("' was updated. From '")
                        .append(dif.getObject1())
                        .append("' to '")
                        .append(dif.getObject2())
                        .append("'")
                        .append("\n");
                default -> result.append("");
            }
        }
        return "\n" + result;
    }
}
