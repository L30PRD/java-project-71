package hexlet.code.format;

import hexlet.code.Difference;

import java.io.IOException;
import java.util.List;

public class Json {

    public static String json(List<Difference> list) throws IOException {
        StringBuilder result = new StringBuilder();
        for (Difference dif : list) {
            if (dif.getObject2() == null) {
                result
                        .append("  ")
                        .append(dif.getStatus())
                        .append(" ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject1())
                        .append("\n");
            } else {
                result.append("  + ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject1())
                        .append("\n")
                        .append("  ")
                        .append(dif.getStatus())
                        .append(" ")
                        .append(dif.getName())
                        .append(": ")
                        .append(dif.getObject2())
                        .append("\n");
            }
        }
        return "{" + "\n" + result + "}";
    }
}
