package week12d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberStatTest {
    @Test
    public void testSoleNumber(){
        assertEquals(1, new NumberStat().soleNumber(new ArrayList<Integer>(List.of(1,2,4,4,20,20,2))));
        assertEquals(2, new NumberStat().soleNumber(new ArrayList<Integer>(List.of(1,1,4,4,20,20,2))));
        assertEquals(1, new NumberStat().soleNumber(new ArrayList<Integer>(List.of(1,20,4,4,20,20,2))));
    }
}
