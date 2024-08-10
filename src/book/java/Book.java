package book.java;

import java.time.Year;

public class Book {
    int ISBN;
    String title;
    String author;
    Year year;

    public Book(int ISBN, String title, String author, Year year) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
