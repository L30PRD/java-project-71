package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public static String plain(List<Difference> list) {
        StringBuilder result = new StringBuilder();

        for (Difference dif : list) {
            switch (dif.getStatus()) {
                case "ADDED" -> result
                        .append("Property '")
                        .append(dif.getName())
                        .append("' was added with value: ")
                        .append(stringCheck(dif.getObject1()))
                        .append("\n");
                case "REMOVED" -> result
                        .append("Property '")
                        .append(dif.getName())
                        .append("' was removed")
                        .append("\n");
                case "UPDATED" -> result
                        .append("Property '")
                        .append(dif.getName())
                        .append("' was updated. From ")
                        .append(stringCheck(dif.getObject1()))
                        .append(" to ")
                        .append(stringCheck(dif.getObject2()))
                        .append("\n");
                default -> result.append("");
            }
        }
        return result.toString();
    }

    public static Object stringCheck(Object obj) {
        return obj instanceof Arrays || obj instanceof List || obj instanceof Map<?, ?>
                ? "[complex value]" : obj;
    }

    //Изменил реализацию Json, что бы не менять класс Difference на HashMap с отличиями файлов
    public static String json(List<Difference> list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
