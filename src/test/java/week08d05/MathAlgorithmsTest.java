package week08d05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void testCalculate() {

        assertEquals(3, new MathAlgorithms().greatestCommonDivisor(6, 3));
        assertEquals(15, new MathAlgorithms().greatestCommonDivisor(15, 15));
        assertEquals(1, new MathAlgorithms().greatestCommonDivisor(3, 1));
    }

    @Test
    public void testCalculateZero() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().greatestCommonDivisor(0, 10));
        assertEquals("Nem lehet negatív szám, sem nulla.", ex.getMessage());
    }

    @Test
    public void testCalculateNegative() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MathAlgorithms().greatestCommonDivisor(-10, 10));
        assertEquals("Nem lehet negatív szám, sem nulla.", ex.getMessage());
    }

}