package main.java;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(int notFoundISBN) {
        super("Book not found with ISBN - " + notFoundISBN);
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
