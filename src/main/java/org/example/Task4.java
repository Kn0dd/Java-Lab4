package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    static void main() {
        try {
            List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors(
                    "src\\main\\resources\\book.json"));
            boolean hasAuthor = visitors.stream()
                    .flatMap(v -> v.getFavoriteBooks().stream())
                    .anyMatch(book -> book.getAuthor().equalsIgnoreCase("Jane Austen"));
            System.out.println(hasAuthor ? "Yes" : "No");
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}
