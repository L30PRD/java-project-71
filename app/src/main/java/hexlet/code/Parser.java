package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> jsonParser(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(str, new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String, Object> ymlParser(String str) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(str, new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String, Object> parser(String filepath, String format) throws Exception {
        return switch (format) {
            case "json" -> jsonParser(filepath);
            case "yml", "yaml" -> ymlParser(filepath);
            default -> throw new IOException("Unknown format");
        };
    }
}
