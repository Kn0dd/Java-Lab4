package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3 {
    static void main() {
        try {
            List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors(
                    "src\\main\\resources\\book.json"));
            List<Book> uniqueSortedByYearBooks = visitors.stream()
                    .flatMap(v -> v.getFavoriteBooks().stream())
                    .distinct()
                    .sorted(Comparator.comparingInt(Book::getPublishingYear))
                    .toList();
            uniqueSortedByYearBooks.stream().forEach(b -> System.out.println(
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
