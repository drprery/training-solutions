package collectionscomp;

public class Book implements Comparable<Book>{
    private int regNumber;
    private String author;
    private String title;

    public Book(int regNumber,String title, String author) {
        this.regNumber = regNumber;
        this.author = author;
        this.title = title;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }
}
