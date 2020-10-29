package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {

        Client client = new Client();

        client.setName("Kovács János");
        client.setYear(1968);
        client.setAddress("2600 Vác Köztársaság út 62-64.");

        System.out.println("Neve: " + client.getName());
        System.out.println("Születési éve: " + client.getYear());
        System.out.println("Lakcíme: " + client.getAddress());

        client.migrate("2629 Márianosztra Pálosok tere 1.");

        System.out.println("Új lakcíme: " + client.getAddress());
    }
}