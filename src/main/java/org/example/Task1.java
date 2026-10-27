package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static void main() {
        List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors());
        System.out.println("Number of visitors: " + visitors.size());
        visitors.stream().forEach(v -> System.out.println(
                v.getName() + " " +
                v.getSurname() + " " +
                v.getPhone()));
    }
}
