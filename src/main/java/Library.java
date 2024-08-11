package main.java;

import book.java.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Integer,Book> allBooksOfLibrary = new HashMap<>();
    private List<Book> booksPresentInLibrary = new ArrayList<>();

    public void addBook(Book bookToAdd) {
        booksPresentInLibrary.add(bookToAdd);
        allBooksOfLibrary.put(bookToAdd.getISBN(), bookToAdd);
    }

    public void borrowBook(int borrowBookISBN) {
        Book bookToBorrow = searchByISBN(borrowBookISBN);

        if (bookToBorrow == null) {
            throw new BookNotFoundException(borrowBookISBN);
        } else {
            booksPresentInLibrary.remove(bookToBorrow);
        }
    }

    /* It might be case like user try to return a book that doesn't belong to our library . So in such case
    * we should throw an exception.
    * so to keep record of every book from library implementing HashMap*/
    public void returnBook(int returnBookISBN) {
        Book bookFromLibrary = bookFromLibrary(returnBookISBN);

        if (bookFromLibrary == null) {      // if book not from our library then it will be null
            throw new IllegalArgumentException("Book doesn't belong to our library: ISBN - " + returnBookISBN);
        }

        // book from our library and already present in library
        if (booksPresentInLibrary.contains(bookFromLibrary)) {
            throw new IllegalArgumentException("Book already exist in library: ISBN- " +returnBookISBN);
        }
    }

    public Book searchByISBN(int currentBookISBN) {

        return booksPresentInLibrary.stream()
                .filter(existingBooks -> existingBooks.getISBN() == currentBookISBN)
                .findFirst()
                .orElse(null);
    }

    public Book bookFromLibrary(int returnBookISBN) {
        return allBooksOfLibrary.get(returnBookISBN);   // return Book object
    }

    public int getNumberOfBooks() {
        return booksPresentInLibrary.size();
    }
}
