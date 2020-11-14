package controladvanced.duplicates;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesTest {
    @Test
    public void findDuplicates(){
        assertEquals(List.of(2,3), new Duplicates(List.of(1,2,2,3,3)).findDuplicates());
        assertEquals(List.of(2), new Duplicates(List.of(2,2,3)).findDuplicates());
    }
}
