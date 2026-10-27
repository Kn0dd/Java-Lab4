package org.example;

import lombok.Value;

import java.util.List;

@Value
public class Visitor {
    String name;
    String surname;
    String phone;
    boolean subscribed;
    List<Book> favoriteBooks;
}
