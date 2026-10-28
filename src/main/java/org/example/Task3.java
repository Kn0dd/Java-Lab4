package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors());
        Set<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .collect(Collectors.toSet());
        List<Book> sortedByYearBooks = uniqueBooks.stream()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .toList();
        sortedByYearBooks.stream().forEach(b -> System.out.println(
                b.getName() + "\t\t" +
                b.getAuthor() + "\t\t" +
                b.getPublishingYear() + "\t\t" +
                b.getIsbn() + "\t\t" +
                b.getPublisher()));
    }
}
