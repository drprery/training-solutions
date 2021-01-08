package week10d05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCalculator() {
        assertEquals(16, new Calculator().findMinSum(new int[]{1, 3, 5, 7, 9}));
        assertEquals(11, new Calculator().findMinSum(new int[]{1, 9, 7, 5, 33, 21, 11}));

    }

    @Test
    void testCalculatorListSize() {
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Calculator().findMinSum(new int[]{10, 8, 71}));
        assertEquals("The list is short!", ex1.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Calculator().findMinSum(new int[]{}));

    }

}
