package covid;

import java.util.Scanner;

public class CovidMain {
    private boolean quit;

    public static void main(String[] args) {
        CovidMain covidMain = new CovidMain();

        covidMain.run();
    }

    public void run(){
        while(!quit){
            printMenu();
            select();
        }
    }

    private void printMenu() {
        System.out.println("***************************");
        System.out.println("* 1. Regisztráció         *");
        System.out.println("* 2. Tömeges regisztráció *");
        System.out.println("* 3. Generálás            *");
        System.out.println("* 4. Oltás                *");
        System.out.println("* 5. Oltás meghiúsulás    *");
        System.out.println("* 6. Kilépés              *");
        System.out.println("***************************");

        System.out.print("Kérem, válasszon: ");
    }

    private void select() {
        Scanner scanner = new Scanner(System.in);

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1 : registration();
                    break;
            case 2 : massRegistration();
                    break;
            case 3 : reportGenerating();
                    break;
            case 4 : vaccination();
                    break;
            case 5 : failedVaccination();
                    break;
            case 6 : quit = true;
                    break;
            default:
                System.out.println("Kérem válasszon újra!\n");
        }
    }

    private void registration(){

    }

    private void massRegistration(){

    }

    private void reportGenerating(){

    }

    private void vaccination(){

    }

    private void failedVaccination(){

    }

}
