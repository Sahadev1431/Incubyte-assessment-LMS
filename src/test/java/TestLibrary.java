package test.java;

import book.java.Book;
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
    public void initialTest() {

    }

    @Test
    public void addBookToLibrary() {
        testbook = new Book(101,"The God of Small Things","Arundhati Roy", Year.of(1997));
        library.addBook(testbook);

        assertEquals(1,library.getNumberOfBooks());
    }

    @Test
    public void nonUniqueISBN_ShouldThrowAnException() {
        testbook = new Book(102,"The God of Small Things","Arundhati Roy", Year.of(1997));
        assertThrows(IllegalArgumentException.class, () -> {
            Book nonUnique = new Book(102,"The God of Small Things","Arundhati Roy", Year.of(1997));
        });
    }

    @Test
    public void borrowBookShouldDecreaseNumberOfBook() {        // test case pass
        testbook = new Book(103,"The God of Small Things","Arundhati Roy", Year.of(1997));
        library.addBook(testbook);
        library.borrowBook(103);
        assertEquals(0,library.getNumberOfBooks());
    }

    @Test
    public void borrowBookShouldThrowAnExceptionOnTryingToBorrowABookThatIsNotAvailable() {  // test case pass
        testbook = new Book(104,"The God of Small Things","Arundhati Roy", Year.of(1997));
        library.addBook(testbook);

        library.borrowBook(104);

        assertThrows(BookNotFoundException.class, () -> {
            library.borrowBook(104);
        });
    }

    @Test
    public void borrowBookShouldThrowAnExceptionOnTryingToBorrowABookThatDoesNotExist() {       // test case pass
        assertThrows(BookNotFoundException.class, () -> {
            library.borrowBook(105);
        });
    }

    @Test
    public void returnBookShouldThrowAnExceptionOnReturningABookThatDoesNotBelongToLibrary() {
        assertThrows(IllegalArgumentException.class, () -> {
             library.returnBook(104);
        });
    }

    @Test
    public void returnBookShouldThrowAnExceptionOnReturningABookThatAlreadyExistInLibrary() {   // test case pass
        testbook = new Book(107,"The God of Small Things 5","Arundhati Roy", Year.of(1997));
        library.addBook(testbook);                  // book added to library
        assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook(107);    // trying to return book exist in library
        });
    }

    @Test
    public void returnBookShouldIncreaseNumberOfBook() {        // test case pass
        testbook = new Book(108,"Manorama Mishra","Maha Kavitha", Year.of(2001));
        library.addBook(testbook);
        library.borrowBook(108);
        library.returnBook(108);
        assertEquals(1,library.getNumberOfBooks());
    }

    @Test
    public void viewAvailableBooksShouldReturnListOfBooksPresentInLibrary() {  // fail test case
        testbook = new Book(109,"Manorama Mishra1","Maha Kavitha1", Year.of(2001));


        library.addBook(testbook);

        List<Book> addedBooks = new ArrayList<>();
        addedBooks.add(testbook);

        assertArrayEquals(addedBooks.toArray() , library.viewAvailableBooks().toArray());
    }
}
