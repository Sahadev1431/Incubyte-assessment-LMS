package book.java;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Book {

    // To ensure that ISBN should be unique
    private static Set<String> uniqueISBNs = new HashSet<>();

    private String ISBN;
    private String title;
    private String author;
    private Year year;

    public Book(String ISBN, String title, String author, Year year) {
        if (uniqueISBNs.contains(ISBN)) {
            throw new IllegalArgumentException("ISBN should be unique: " + ISBN);
        }

        uniqueISBNs.add(ISBN);
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }
}
