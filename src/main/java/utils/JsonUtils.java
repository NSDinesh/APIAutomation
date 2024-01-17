package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

    private JsonUtils(){

    }

    public static final Map<String,String> getJsonDataAsMap(String jsonFilePath) {
        Map<String,String> data = new HashMap<>();
        try {
            data = new ObjectMapper().readValue(new File(jsonFilePath),new TypeReference<>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
