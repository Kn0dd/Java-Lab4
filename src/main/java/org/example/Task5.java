package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors());
        int maxNumber = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max()
                .orElse(0);
        System.out.println("Max number of favorite books: " + maxNumber);
    }
}
