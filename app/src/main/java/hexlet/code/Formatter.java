package hexlet.code;

import hexlet.code.formats.Json;
import hexlet.code.formats.Plain;
import hexlet.code.formats.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> dif, String format) throws IOException {
        return switch (format) {
            case "json" -> Json.makeJson(dif);
            case "plain" -> Plain.makePlain(dif);
            case "stylish" -> Stylish.makeStylish(dif);
            default -> throw new IOException("Unknown format.");
        };
    }
}
