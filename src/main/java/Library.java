package main.java;

import book.java.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksOfLibrary = new ArrayList<>();

    public void addBook(Book bookToAdd) {
        booksOfLibrary.add(bookToAdd);
    }

    public void borrowBook(int ISBN) {

    }

    public int getNumberOfBooks() {
        return booksOfLibrary.size();
    }
}
