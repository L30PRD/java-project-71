package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.format.Json;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String generate(String filePath1, String filePath2, String formatName)  throws Exception  {
        Map<String, Object> file1 = getData(filePath1);
        Map<String, Object> file2 = getData(filePath2);
        List<Difference> list = Comparator.comparator(file1, file2);

        switch (formatName) {
            case ("JSON"):
                return Json.json(list);
            default:
                return "stylish";
        }
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }
        return objectMapper.readValue(new File(filepath), new TypeReference<Map<String, Object>>() { });
    }
}
