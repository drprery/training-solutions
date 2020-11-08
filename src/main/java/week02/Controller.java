package week02;

import java.util.Scanner;

public class Controller {
    private Office office;
    private Scanner scanner = new Scanner(System.in);

    public void readOffice() {
        office = new Office();

        System.out.print("A rögzítendő tárgyalók száma: ");
        int mRooms = Integer.parseInt(scanner.nextLine());
        System.out.println();

        for (int i = 1; i <= mRooms; i++) {
            System.out.print("A tárgyaló neve: ");
            String mRoomName = scanner.nextLine();

            System.out.print("A tárgyaló szélessége méterben: ");
            int mRoomWidth = Integer.parseInt(scanner.nextLine());

            System.out.print("A tárgyaló hosszúsága méterben: ");
            int mRoomLength = Integer.parseInt(scanner.nextLine());
            System.out.println();

            office.addMeetingRoom(new MeetingRoom(mRoomName, mRoomWidth, mRoomLength));
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafelé sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
        System.out.println("8. Kilépés a programból");
        System.out.println();
    }

    public void runMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.print("A kért funkció száma:");
            int funcNum = Integer.parseInt(scanner.nextLine());
            switch (funcNum) {
                case 1:
                    office.printNames();
                    System.out.println();
                    printMenu();
                    break;
                case 2:
                    office.printNamesReverse();
                    System.out.println();
                    printMenu();
                    break;
                case 3:
                    office.printEvenNames();
                    System.out.println();
                    printMenu();
                    break;
                case 4:
                    office.printAreas();
                    System.out.println();
                    printMenu();
                    break;
                case 5:
                    System.out.print("A keresett tárgyaló neve:");
                    String name = scanner.nextLine();
                    System.out.println();
                    office.printMeetingRoomsWithName(name);
                    System.out.println();
                    printMenu();
                    break;
                case 6:
                    System.out.print("A keresett tárgyaló nevének töredéke: ");
                    String pName = scanner.nextLine();
                    System.out.println();
                    office.printMeetingRoomsContains(pName);
                    System.out.println();
                    printMenu();
                    break;
                case 7:
                    System.out.print("A keresett tárgyaló területe: ");
                    int area = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    office.printAreasLargerThan(area);
                    System.out.println();
                    printMenu();
                    break;
                case 8:
                    quit = true;
                    break;
                default:
                    System.out.println("Nincs ilyen funkció! Kérem újra!");
                    System.out.println();
            }
        }
        System.exit(1);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }
}
