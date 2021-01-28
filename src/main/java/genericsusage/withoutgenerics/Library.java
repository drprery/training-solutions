package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }

        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        }

        Object book = books.get(0);

        if (!(book instanceof Book)) {
            throw new ClassCastException("Not a book");
        }

        return (Book) book;
    }
}
