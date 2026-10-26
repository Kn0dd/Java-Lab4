package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static void main() {
        try {
            List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors(
                "src\\main\\resources\\book.json"));
            List<Book> uniqueBooks = visitors.stream()
                    .flatMap(v -> v.getFavoriteBooks().stream())
                    .distinct()
                    .toList();
            System.out.println("Number of unique books: " + uniqueBooks.size());
            uniqueBooks.stream().forEach(b -> System.out.println(
                    b.getName() + "\t\t" +
                    b.getAuthor() + "\t\t" +
                    b.getPublishingYear() + "\t\t" +
                    b.getIsbn() + "\t\t" +
                    b.getPublisher()));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}
