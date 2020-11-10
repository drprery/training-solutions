package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Első kör átmérője: ");
        int diameter1 = scanner.nextInt();
        Circle circle1 = new Circle(diameter1);
        System.out.println();

        System.out.print("Második kör átmérője: ");
        int diameter2 = scanner.nextInt();
        Circle circle2 = new Circle(diameter2);
        System.out.println();

        System.out.println("1. kör kerülete: " + circle1.perimeter());
        System.out.println("1. kör területe: " + circle1.area());
        System.out.println("---------------------------------------");
        System.out.println("2. kör kerülete: " + circle2.perimeter());
        System.out.println("2. kör területe: " + circle2.area());
    }
}
