package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client=new Client();
        Scanner scanner=new Scanner(System.in);

        System.out.println("Név: ");
        client.name=scanner.nextLine();
        System.out.println("Születési év: ");
        client.year=scanner.nextInt();
        System.out.println("Cím: ");
        client.address=scanner.nextLine();
        client.address=scanner.nextLine();

        System.out.println("A bekért adatok a következők:");
        System.out.println("Név :"+client.name);
        System.out.println("Születési év: "+client.year);
        System.out.println("Cím: "+client.address);

    }
}
