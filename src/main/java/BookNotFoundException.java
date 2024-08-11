package main.java;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String notFoundISBN) {
        super("Book not found with ISBN - " + notFoundISBN);
    }

}
