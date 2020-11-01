package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Írjál be egy egész számot: ");
        int i=scanner.nextInt();

        System.out.println("A szám hárommal "+((i % 3 == 0) ? "osztható." : "nem osztható."));
    }
}