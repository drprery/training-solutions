package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();

        System.out.println("*** subtractTenIfGreaterThanTen ***");
        System.out.println(introControl.subtractTenIfGreaterThanTen(3));
        System.out.println(introControl.subtractTenIfGreaterThanTen(10));
        System.out.println(introControl.subtractTenIfGreaterThanTen(25));
        System.out.println();

        System.out.println("*** describeNumber ***");
        System.out.println(introControl.describeNumber(10));
        System.out.println(introControl.describeNumber(0));
        System.out.println();

        System.out.println("*** greetingToJoe ***");
        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Doe"));
        System.out.println();

        System.out.println("*** calculateBonus ***");
        System.out.println(introControl.calculateBonus(0));
        System.out.println(introControl.calculateBonus(1000));
        System.out.println(introControl.calculateBonus(1000000));
        System.out.println(introControl.calculateBonus(1100000));
        System.out.println();

        System.out.println("*** calculateConsumption ***");
        System.out.println(introControl.calculateConsumption(100, 200));
        System.out.println(introControl.calculateConsumption(9995, 100));
        System.out.println();

        System.out.println("*** printNumbers ***");
        introControl.printNumbers(20);
        System.out.println("*** printNumbersBetween ***");
        introControl.printNumbersBetween(1, 20);
        System.out.println();

        System.out.println("*** printNumbersBetweenAnyDirection ***");
        introControl.printNumbersBetweenAnyDirection(100, 110);
        System.out.println("*** printNumbersBetweenAnyDirection - reverse ***");
        introControl.printNumbersBetweenAnyDirection(110, 100);
        System.out.println();

        System.out.println("*** printOddNumbers - 3 ***");
        introControl.printOddNumbers(3);
        System.out.println("*** printOddNumbers - 20 ***");
        introControl.printOddNumbers(20);
        System.out.println("*** printOddNumbers - 19 ***");
        introControl.printOddNumbers(19);
    }
}
