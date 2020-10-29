package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Song song=new Song();

        System.out.println("A dal előadója: ");
        song.band=scanner.nextLine();
        System.out.println("A dal címe: ");
        song.title=scanner.nextLine();
        System.out.println("A dal hossza percben: ");
        song.lenght= scanner.nextInt();

        System.out.println();
        System.out.println(song.band+" - "+song.title+" ("+song.lenght+" perc)");
    }
}
