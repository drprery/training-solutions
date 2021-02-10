package sorting;

import java.util.*;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById(){
        int bookArrayLength = bookArray.length;
        Book[] books = new Book[bookArrayLength];

        System.arraycopy(bookArray, 0, books, 0, bookArrayLength);
        Arrays.sort(books);

        return books;
    }

    public Book[] sortingByTitle() {
        Comparator<Book> titleComparator = new Comparator<Book>() {
            public int compare(Book bookA, Book bookB) {
                return bookA.getTitle().compareTo(bookB.getTitle());
            }
        };

        int bookArrayLength = bookArray.length;
        Book[] books = new Book[bookArrayLength];
        System.arraycopy(bookArray, 0, books, 0, bookArrayLength);
        Arrays.sort(books, titleComparator);

        return books;
    }
}
