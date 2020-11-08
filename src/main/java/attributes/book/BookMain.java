package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Galaxis útikalauz");
        System.out.println(book.getTitle());

        book.setTitle("Bajnokok reggelije");
        System.out.println(book.getTitle());
    }
}
