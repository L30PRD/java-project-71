package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.format.Json;
import hexlet.code.format.Stylish;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static ObjectMapper objectMapper;

    public static String generate(String filePath1, String filePath2, String formatName)  throws Exception  {
        Map<String, Object> file1 = getData(filePath1);
        Map<String, Object> file2 = getData(filePath2);
        List<Difference> list = Comparator.comparator(file1, file2);

        switch (formatName) {
            case ("JSON"):
                return Json.json(list);
            default:
                return Stylish.stylish(list);
        }
    }

    public static String generate(String filePath1, String filePath2)  throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }
        if (filepath.endsWith("json")) {
            objectMapper = new ObjectMapper();
        } else if (filepath.endsWith("yml")) {
            objectMapper = new YAMLMapper();
        }
        return objectMapper.readValue(new File(filepath), new TypeReference<Map<String, Object>>() { });
    }
}
