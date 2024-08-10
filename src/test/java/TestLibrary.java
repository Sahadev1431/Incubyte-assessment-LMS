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

    public void addBookToLibrary() {
        testbook = new Book(101,"The God of Small Things","Arundhati Roy", Year.of(1997));
        library.addBook(testbook);

        assertEquals(1,library.getNumberOfBooks());
    }
}
