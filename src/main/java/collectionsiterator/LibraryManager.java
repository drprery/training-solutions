package collectionsiterator;

import java.util.*;

public class LibraryManager {
    private Set<Book> libraryBooks = new HashSet<>();

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber){
        for(Book book : libraryBooks){
            if(book.getRegnumber()==regNumber){
                return new Book(book.getRegnumber(), book.getTitle(), book.getAuthor());
            }
        }
        throw new MissingBookException("No books found with regnumber: "+regNumber);
    }

    public int removeBookByRegNumber(int regNumber){
        Iterator it = libraryBooks.iterator();

        while(it.hasNext()){
            Book book = (Book) it.next();
            if(book.getRegnumber()==regNumber){
                int rnum=book.getRegnumber();
                it.remove();
                return rnum;
            }
        }
        throw new MissingBookException("No books found with regnumber: "+regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author){
        Set<Book> selectedBooks = new HashSet<>();
        Iterator it = libraryBooks.iterator();

        while(it.hasNext()){
            Book book = (Book) it.next();
            if(book.getAuthor().equals(author)){
                selectedBooks.add(book);
            }
        }
        if(selectedBooks.size()==0){
            throw new MissingBookException("No books found by "+author);
        }
        return selectedBooks;
    }

    public int libraryBooksCount(){
        return libraryBooks.size();
    }
}
