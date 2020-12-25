package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibCalculatorTest {
    @Test
    public void testIfBoundIsTen(){
        assertEquals(20,FibCalculator.sumEvens(10));
    }

    @Test
    public void testIfBoundIsTwentyTwo(){
        assertEquals(54,FibCalculator.sumEvens(22));
    }

    @Test
    public void testIfBoundIsThirtyFour(){
        assertEquals(88,FibCalculator.sumEvens(34));
    }
}
