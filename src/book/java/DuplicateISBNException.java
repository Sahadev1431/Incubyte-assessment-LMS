package book.java;

public class DuplicateISBNException extends RuntimeException {
    public DuplicateISBNException(String ISBN) {
        super("ISBN should be unique" + ISBN);
    }
}
