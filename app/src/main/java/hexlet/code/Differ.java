package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatName)  throws Exception  {
        Map<String, Object> file1 = getData(filePath1);
        Map<String, Object> file2 = getData(filePath2);
        List<Difference> list = Comparator.comparator(file1, file2);

        switch (formatName) {
            case ("json"):
                return Formatter.json(list);
            case ("plain"):
                return Formatter.plain(list);
            case ("stylish"):
                return Formatter.stylish(list);
            default:
                return Formatter.stylish(list);
        }
    }

    public static String generate(String filePath1, String filePath2)  throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String format(String filepath) {
        String[] array = filepath.split("\\.");
        return array[array.length - 1];
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }
        String file = Files.readString(path);
        String format = format(filepath);
        return Parser.parser(file, format);
    }
}
