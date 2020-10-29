package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Zsoldos Péter", "Távoli tűz");

        book.register("1969");

        System.out.println("A szerző neve : " + book.getAuthor());
        System.out.println("A könyv címe : " + book.getTitle());
        System.out.println("A könyv regisztrációs száma : " + book.getRegNumber());
    }
}
