package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors());
        boolean hasAuthor = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(book -> book.getAuthor()
                .equalsIgnoreCase("Jane Austen"));
        System.out.println(hasAuthor ? "Yes" : "No");
    }
}
