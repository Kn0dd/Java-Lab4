package org.example;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors());
        Set<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("Number of unique books: " + uniqueBooks.size());
        uniqueBooks.stream().forEach(b -> System.out.println(
                b.getName() + "\t\t" +
                b.getAuthor() + "\t\t" +
                b.getPublishingYear() + "\t\t" +
                b.getIsbn() + "\t\t" +
                b.getPublisher()));
    }
}
