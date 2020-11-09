package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person person = new Person("Kovács János", 64);
        Person otherPerson = person;

        otherPerson.setName("Kovács Péter");

        System.out.println(person.getName() + " " + person.getAge());
        System.out.println(otherPerson.getName() + " " + otherPerson.getAge());
        // Mindkettő ugyanarra az objektumra mutat, mert referencia másolás volt.

        int number1 = 24;
        int number2 = number1;

        number2++;

        System.out.println(number1);
        System.out.println(number2);
        // Csak a number2 változott, mert az érték át lett másolva.

        otherPerson = new Person("Kovács Mari", 63);
        System.out.println(person.getName() + " " + person.getAge());
        System.out.println(otherPerson.getName() + " " + otherPerson.getAge());
        // A két változóban az értékek különbözőek, mert az otherPerson referenciája már más objektumra mutat.
    }
}
