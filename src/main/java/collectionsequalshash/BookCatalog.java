package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book book = new Book(title, author);

        if (!books.contains(book)) {
            return null;
        }

        int ind = books.indexOf(book);
        return books.get(ind);
    }

    public Book findBook(List<Book> books, Book book) {
        if (!(books.contains(book))) {
            return null;
        }

        int ind = books.indexOf(book);
        return books.get(ind);
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> setOfBooks = new HashSet<>();

        for (Book book : books) {
            setOfBooks.add(book);
        }

        return setOfBooks;
    }
}
