package test.java;

import book.java.Book;
import main.java.Library;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;

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
    public void borrowBookShouldDecreaseNumberOfBook() {
        testbook = new Book(103,"The God of Small Things","Arundhati Roy", Year.of(1997));
        library.addBook(testbook);
        library.borrowBook(103);
        assertEquals(0,library.getNumberOfBooks());

    }
}
