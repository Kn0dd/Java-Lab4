package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
    static void main() {
        try {
            List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors(
                    "src\\main\\resources\\book.json"));
            int maxNumber = visitors.stream()
                    .mapToInt(v -> v.getFavoriteBooks().size())
                    .max()
                    .orElse(0);
            System.out.println("Max number of favorite books: " + maxNumber);
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}
