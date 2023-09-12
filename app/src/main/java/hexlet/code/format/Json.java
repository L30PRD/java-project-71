package hexlet.code.format;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Difference;

import java.io.IOException;
import java.util.List;

public class Json {

    public static String json(List<Difference> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
