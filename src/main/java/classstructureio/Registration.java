package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Felhasználó neve:");
        String name=scanner.nextLine();
        System.out.println("Email címe:");
        String email=scanner.nextLine();

        System.out.println("A felhasználó neve: "+name);
        System.out.println("A felhasználó email címe: "+email);
    }
}
