package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    @TempDir
    public File folder;

    @Test
    public void testLibrarySaving(){
        Path file = new File(folder, "test.txt").toPath();
        Library library = new Library();

        library.add(new Book("X Y","Xxx"));
        library.add(new Book("Q W","Qqq"));
        library.add(new Book("A S","Aaa"));
        library.saveBooks(file);

        Library library1 = new Library();
        library1.loadBooks(file);
        assertEquals("X Y",library1.getBooks().get(0).getAuthor());
        assertEquals("Xxx",library1.getBooks().get(0).getTitle());
        assertEquals("Q W",library1.getBooks().get(1).getAuthor());
        assertEquals("Qqq",library1.getBooks().get(1).getTitle());
        assertEquals("A S",library1.getBooks().get(2).getAuthor());
        assertEquals("Aaa",library1.getBooks().get(2).getTitle());
    }
}
