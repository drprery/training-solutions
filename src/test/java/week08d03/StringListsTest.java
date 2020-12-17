package week08d03;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListsTest {
    @Test
    public void testUnion(){
        List<String> first=List.of("Egy","Három","Öt");
        List<String> second=List.of("Kettő","Három","Négy","Hat");

        assertEquals(Set.of("Egy","Kettő","Három","Hat","Négy","Öt"),StringLists.stringListsUnion(first,second));

    }
}
