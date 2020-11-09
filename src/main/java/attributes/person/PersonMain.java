package attributes.person;

public class PersonMain {

    public static void main(String[] args) {
        PersonMain personMain = new PersonMain();

        Person person = new Person("Kovács 23 János", "EE123456");

        Address address = new Address("Magyarország", "Budapest", "Csontváry tca 27. 10. emelet", "H-1181");
        person.moveTo(address);

        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        person.correctData("Kovács 23 János 1", "DC123499");
        System.out.println(person.personToString());

        person.getAddress().correctData("Magyarország", "Budapest XVIII. kerület", "Csontváry tca 27. 10. emelet", "H-1181");

        System.out.println(person.getAddress().addressToString());

        Address newAddress = new Address("Magyarország", "Budapest", "Bimbó út 28.",  "H-1022");

        person.moveTo(newAddress);

        System.out.println(person.getAddress().addressToString());
    }
}
