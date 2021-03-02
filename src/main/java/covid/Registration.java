package covid;

import java.util.*;

public class Registration {
    private static Scanner scanner = new Scanner(System.in);
    private static Validator validator = new Validator();
    private static CitizenDao citizenDao = new CitizenDao();

    public static String nameInput() {
        do {
            System.out.println();
            System.out.print("Írja be a nevét: ");
            String name = scanner.nextLine();
            if (validator.isValidFullName(name)) {
                return name;
            }
            System.out.println("A név nem lehet üres!");
        } while (true);
    }

    public static String zipInput(){
        do {
            System.out.println();
            System.out.print("Írja be az irányítószámát: ");
            String zip = scanner.nextLine();
            if (validator.isValidZipCode(zip)) {
                return zip;
            }
            System.out.println("Az irányítószám helytelen, kérem adja meg újra!");
        } while (true);
    }

    public static int ageInput(){
        do {
            System.out.println();
            System.out.print("Írja be az életkorát: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (validator.isValidAge(age)) {
                return age;
            }
            System.out.println("Csak 10 és 150 év közötti adat fogadható el, kérem adja meg újra!");
        } while (true);
    }

    public static String emailInput(){
        do {
            System.out.println();
            System.out.print("Írja be az E-mail címét: ");
            String email = scanner.nextLine();
            if (validator.isValidEmail(email)) {
                return email;
            }
            System.out.println("Szabálytalan E-mail cím, kérem adja meg újra!");
        } while (true);
    }

    public static String ssnInput(){
        do {
            System.out.println();
            System.out.print("Írja be a TAJ számát: ");
            String ssn = scanner.nextLine();
            if (validator.isValidSsn(ssn)) {
                return ssn;
            }
            System.out.println("Érvénytelen TAJ szám, kérem adja meg újra!");
        } while (true);
    }
}

