package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        UserValidator userValidator=new UserValidator();

        System.out.println("A felhasználó neve: ");
        String name=scanner.nextLine();
        System.out.println("A felhasználó jelszava: ");
        String password=scanner.nextLine();
        System.out.println("A felhasználó jelszava újra: ");
        String password2=scanner.nextLine();
        System.out.println("A felhasználó email címe: ");
        String email=scanner.nextLine();

        System.out.println(userValidator.isValidUsername(name) ? "A felhasználó neve megfelelő." : "A felhasználó neve nem megfelelő!");
        System.out.println(userValidator.isValidPassword(password, password2) ? "A jelszó megfelelő." : "A jelszó nem megfelelő!");
        System.out.println(userValidator.isValidEmail(email) ? "Az e-mail cím megfelelő." : "Az e-mail cím nem megfelelő!");
    }
}
