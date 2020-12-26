package week09d03;

import org.junit.jupiter.api.Test;
import java.util.List;

public class SantaClausTest {
    @Test
    public void testPresent() {
        SantaClaus santaClaus = new SantaClaus(List.of(new Person("John Doe", 45), new Person("Jane Doe", 19), new Person("Jack Doe", 10)));

        santaClaus.getThroughChimneys();
        List<Person> persons=santaClaus.getPersons();
        for(Person person:persons){
            System.out.println(person.getName()+" "+person.getAge()+" "+person.getPresent());
        }
    }
}
