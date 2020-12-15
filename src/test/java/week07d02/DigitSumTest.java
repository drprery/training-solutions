package week07d02;

import org.junit.jupiter.api.Test;
import week07.d02.DigitSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {
    @Test
    public void testNumbers() {
        DigitSum digitSum = new DigitSum();

        assertEquals(6, digitSum.sumOfDigits(123));
    }
}