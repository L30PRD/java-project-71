package hexlet.code;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatName)  throws Exception  {
        Map<String, Object> file1 = getData(filePath1);
        Map<String, Object> file2 = getData(filePath2);
        List<Map<String, Object>> list = Comparator.comparator(file1, file2);

        return Formatter.format(list, formatName);
    }

    public static String generate(String filePath1, String filePath2)  throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String extension(String filepath) throws IOException {
        String[] array = filepath.split("\\.");
        String ext = array[array.length - 1];
        return switch (ext) {
            case "json", "yml", "yaml" -> ext;
            default -> throw new IOException("Unknown Format");
        };
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }
        String file = Files.readString(path);
        String format = extension(filepath);
        return Parser.parser(file, format);
    }
}
