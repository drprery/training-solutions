package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {
    private List<Book> books = new ArrayList<>();

    public CollectionManager(List<Book> books) {
        this.books = books;
    }

    public List<Book> createUnmodifiableLibrary(){
        return Collections.unmodifiableList(books);
    }

    public List<Book> reverseLibrary(){
        List<Book> books2 = new ArrayList<>(books);
        Collections.sort(books2);
        Collections.reverse(books2);
        return books2;
    }

    public Book getFirstBook(){
        return Collections.min(books);
    }

    public Book getLastBook(){
        return Collections.max(books);
    }
}
