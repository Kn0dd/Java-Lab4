package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public static List<Visitor> loadVisitors(String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(fileName);
        var visitorType = TypeToken.getParameterized(List.class, Visitor.class).getType();
        return new ArrayList<>(gson.fromJson(fileReader, visitorType));
    }
}
