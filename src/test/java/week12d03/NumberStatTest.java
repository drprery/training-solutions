package week12d03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberStatTest {
    @Test
    public void testSoleNumber(){
        assertEquals(3, new NumberStat().soleNumber());
    }
}
