package test.java;

import book.java.Book;
import book.java.DuplicateISBNException;
import main.java.BookNotFoundException;
import main.java.Library;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TestLibrary {
    Library library;
    Book testbook;

    @Before
    public void setup() {
        library = new Library();
    }

    @Test
    public void addBookToLibrary() {
        testbook = new Book("111-222-333", "The God of Small Things", "Arundhati Roy", Year.of(1997));
        library.addBook(testbook);

        assertEquals(1, library.getNumberOfBooks());
    }

    @Test
    public void nonUniqueISBN_ShouldThrowAnException() {
        testbook = new Book("111-345-678", "The God of Small Things", "Arundhati Roy", Year.of(1997));
        assertThrows(DuplicateISBNException.class, () -> {
            Book nonUnique = new Book("111-345-678", "The God of Small Things", "Arundhati Roy", Year.of(1997));
        });
    }

    @Test
    public void borrowBookShouldDecreaseNumberOfBook() {
        testbook = new Book("111-222-334", "The God of Small Things", "Arundhati Roy", Year.of(1997));
        library.addBook(testbook);
        library.borrowBook("111-222-334");
        assertEquals(0, library.getNumberOfBooks());
    }

    @Test
    public void borrowBookShouldThrowAnExceptionOnTryingToBorrowABookThatIsNotAvailable() {
        testbook = new Book("111-222-335", "The God of Small Things", "Arundhati Roy", Year.of(1997));
        library.addBook(testbook);

        library.borrowBook("111-222-335");

        assertThrows(BookNotFoundException.class, () -> {
            library.borrowBook("111-222-335");
        });
    }

    @Test
    public void borrowBookShouldThrowAnExceptionOnTryingToBorrowABookThatDoesNotExist() {
        assertThrows(BookNotFoundException.class, () -> {
            library.borrowBook("111-222-336");
        });
    }

    @Test
    public void returnBookShouldThrowAnExceptionOnReturningABookThatDoesNotBelongToLibrary() {
        assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("111-222-337");
        });
    }

    @Test
    public void returnBookShouldThrowAnExceptionOnReturningABookThatAlreadyExistInLibrary() {
        testbook = new Book("111-222-338", "The God of Small Things 5", "Arundhati Roy", Year.of(1997));
        library.addBook(testbook);
        assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("111-222-338");
        });
    }

    @Test
    public void returnBookShouldIncreaseNumberOfBook() {
        testbook = new Book("111-222-339", "Manorama Mishra", "Maha Kavitha", Year.of(2001));
        library.addBook(testbook);
        library.borrowBook("111-222-339");
        library.returnBook("111-222-339");
        assertEquals(1, library.getNumberOfBooks());
    }

    @Test
    public void viewAvailableBooksShouldReturnListOfBooksPresentInLibrary() {
        testbook = new Book("111-222-340", "Manorama Mishra1", "Maha Kavitha1", Year.of(2001));

        library.addBook(testbook);

        List<Book> addedBooks = new ArrayList<>();
        addedBooks.add(testbook);

        assertArrayEquals(addedBooks.toArray(), library.viewAvailableBooks().toArray());
    }

    @Test
    public void shouldReturnTrueIfBookPresentInLibrary() {
        testbook = new Book("111-222-341", "Manorama Mishra2", "Maha Kavitha2", Year.of(2001));
        Book test2 = new Book("111-222-342", "Manorama Mishra3", "Maha Kavitha3", Year.of(2001));

        library.addBook(testbook);
        library.addBook(test2);

        List<Book> booksPresentInLibrary = library.viewAvailableBooks();

        assertTrue(booksPresentInLibrary.contains(testbook));
        assertTrue(booksPresentInLibrary.contains(test2));
    }

    @Test
    public void shouldReturnFalseIfBookHasBorrowed() {
        testbook = new Book("111-222-343", "Manorama Mishra4", "Maha Kavitha2", Year.of(2001));
        library.addBook(testbook);
        library.borrowBook("111-222-343");

        List<Book> booksPresentInLibrary = library.viewAvailableBooks();
        assertFalse(booksPresentInLibrary.contains(testbook));
    }
}
