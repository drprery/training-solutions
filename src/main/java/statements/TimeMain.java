package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Az első időpont órája: ");
        int hours1=scanner.nextInt();

        System.out.println("Az első időpont perce: ");
        int minutes1=scanner.nextInt();

        System.out.println("Az első időpont másodperce: ");
        int seconds1=scanner.nextInt();

        System.out.println("A második időpont órája: ");
        int hours2=scanner.nextInt();

        System.out.println("A második időpont perce: ");
        int minutes2=scanner.nextInt();

        System.out.println("A második időpont másodperce: ");
        int seconds2=scanner.nextInt();

        Time time1=new Time(hours1, minutes1, seconds1);
        Time time2=new Time(hours2, minutes2, seconds2);

        System.out.println("Az első időpont "+time1.toString()+" ,azaz "+time1.getInMinutes()+" perc.");
        System.out.println("A második időpont "+time2.toString()+" ,azaz "+time2.getInSeconds()+" másodperc.");
        System.out.println("Az első időpont korábbi, mint a második: "+((time1.earlierThan(time2)) ? "igaz" : "nem igaz"));
    }
}
