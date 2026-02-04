package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonData {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode read(String resourcePath) {
        try (InputStream is = JsonData.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) throw new RuntimeException("JSON file not found: " + resourcePath);
            return mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON: " + resourcePath, e);
        }
    }

    public static String getString(String resourcePath, String jsonPointer) {
        JsonNode root = read(resourcePath);
        JsonNode node = root.at(jsonPointer); // JSON Pointer syntax
        if (node.isMissingNode()) {
            throw new RuntimeException("Missing JSON path: " + jsonPointer + " in " + resourcePath);
        }
        return node.asText();
    }
}
