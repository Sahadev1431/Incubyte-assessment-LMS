package main.java;

import book.java.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksOfLibrary = new ArrayList<>();

    public void addBook(Book bookToAdd) {
        booksOfLibrary.add(bookToAdd);
    }

    public void borrowBook(int borrowBookISBN) {
        Book bookToBorrow = searchByISBN(borrowBookISBN);

        if (bookToBorrow == null) {
            throw new BookNotFoundException(borrowBookISBN);
        } else {
            booksOfLibrary.remove(bookToBorrow);
        }
    }

    public Book searchByISBN(int currentBookISBN) {

        return booksOfLibrary.stream()
                .filter(existingBooks -> existingBooks.getISBN() == currentBookISBN)
                .findFirst()
                .orElse(null);
    }

    public int getNumberOfBooks() {
        return booksOfLibrary.size();
    }
}
