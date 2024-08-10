package book.java;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Book {

    Set<Integer>uniqueISBNS = new HashSet<>();
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
