package org.example;

import lombok.Value;

@Value
public class Book {
    String name;
    String author;
    int publishingYear;
    String isbn;
    String publisher;
}
