package main.java;

import book.java.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> booksOfLibrary = new ArrayList<>();
    public void addBook(Book bookToAdd) {
        booksOfLibrary.add(bookToAdd);
    }

    public int getNumberOfBooks() {
        return booksOfLibrary.size();
    }
}
