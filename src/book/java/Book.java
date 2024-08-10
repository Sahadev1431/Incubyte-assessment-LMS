package book.java;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Book {

    private static Set<Integer>uniqueISBNs = new HashSet<>();
    private int ISBN;
    private String title;
    private String author;
    private Year year;

    public Book(int ISBN, String title, String author, Year year) {
        if (uniqueISBNs.contains(ISBN)) {
            throw new IllegalArgumentException("ISBN should be unique " + ISBN);
        }

        uniqueISBNs.add(ISBN);
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
