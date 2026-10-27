package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    public static List<Visitor> loadVisitors() {
        Gson gson = new Gson();
        var visitorType = TypeToken.getParameterized(List.class, Visitor.class).getType();
        try (FileReader fileReader = new FileReader("src/main/resources/book.json")) {
            return gson.fromJson(fileReader, visitorType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
