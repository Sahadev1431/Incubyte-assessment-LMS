package main.java;

import book.java.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> allBooksOfLibrary = new HashMap<>();
    private List<Book> booksPresentInLibrary = new ArrayList<>();

    public void addBook(Book bookToAdd) {
        booksPresentInLibrary.add(bookToAdd);
        allBooksOfLibrary.put(bookToAdd.getISBN(), bookToAdd);
    }

    public void borrowBook(String borrowBookISBN) {
        Book bookToBorrow = searchByISBN(borrowBookISBN);

        if (bookToBorrow == null) {
            throw new BookNotFoundException(borrowBookISBN);
        } else {
            booksPresentInLibrary.remove(bookToBorrow);
        }
    }

    public void returnBook(String returnBookISBN) {
        Book bookFromLibrary = getBookFromLibrary(returnBookISBN);

        if (bookFromLibrary == null) {
            throw new IllegalArgumentException("Book doesn't belong to our library: ISBN - " + returnBookISBN);
        }

        if (booksPresentInLibrary.contains(bookFromLibrary)) {
            throw new IllegalArgumentException("Book already exists in library: ISBN - " + returnBookISBN);
        }

        booksPresentInLibrary.add(bookFromLibrary);
    }

    public List<Book> viewAvailableBooks() {
        return booksPresentInLibrary;
    }

    public Book searchByISBN(String currentBookISBN) {
        return booksPresentInLibrary.stream()
                .filter(existingBooks -> existingBooks.getISBN().equals(currentBookISBN))
                .findFirst()
                .orElse(null);
    }

    public Book getBookFromLibrary(String returnBookISBN) {
        return allBooksOfLibrary.get(returnBookISBN);
    }

    public int getNumberOfBooks() {
        return booksPresentInLibrary.size();
    }
}
