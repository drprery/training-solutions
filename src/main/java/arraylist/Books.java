package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        for (String i : titles) {
            if (i.indexOf(prefix) == 0) {
                results.add(i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Keleti szél");
        books.add("Karnevál");
        books.add("Pokol");
        books.add("A renegát");

        System.out.println(books.getTitles().toString());

        System.out.println(books.findAllByPrefix("A").toString());
    }
}
