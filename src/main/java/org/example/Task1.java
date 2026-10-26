package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static void main() {
        try {
            List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors(
                    "src\\main\\resources\\book.json"));
            System.out.println("Number of visitors: " + visitors.size());
            visitors.stream().forEach(v -> System.out.println(
                    v.getName() + " " +
                    v.getSurname() + " " +
                    v.getPhone()));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}
