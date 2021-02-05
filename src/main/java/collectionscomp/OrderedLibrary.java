package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle(){
        Collections.sort(libraryBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return new ArrayList<>(libraryBooks);
    }

    public List<Book> orderedByAuthor(){
        Collections.sort(libraryBooks, new AuthorComparator());

        return new ArrayList<>(libraryBooks);
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> orderedList = new ArrayList<>();

        for (Book book : libraryBooks) {
            orderedList.add(book.getTitle());
        }

        Collator hunCollator = Collator.getInstance(locale);
        hunCollator.setStrength(Collator.PRIMARY);
        Collections.sort(orderedList, hunCollator);

        return orderedList;
    }
}
