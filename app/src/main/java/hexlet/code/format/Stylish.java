package hexlet.code.format;

import hexlet.code.Difference;

import java.util.List;

public class Stylish {

    public static String stylish(List<Difference> list) {
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
