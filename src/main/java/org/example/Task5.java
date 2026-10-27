package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    static void main() {
        List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors());
        int maxNumber = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max()
                .orElse(0);
        System.out.println("Max number of favorite books: " + maxNumber);
    }
}
