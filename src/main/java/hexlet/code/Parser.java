package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String format) throws IOException {
        final ObjectMapper objectMapper = switch (format) {
            case "json" -> new ObjectMapper(new JsonFactory());
            default -> throw new RuntimeException();
        };
        return objectMapper.readValue(data, new TypeReference<>() {
        });

    }
}
