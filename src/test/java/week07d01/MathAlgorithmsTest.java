package week07d01;

import org.junit.jupiter.api.Test;
import week05d02.ChangeLetter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {
    @Test
    public void testNumberIsPrime(){
        assertEquals(true,MathAlgorithms.isPrime(7));
    }

    @Test
    public void testNumberIsNotPrime(){
        assertEquals(false,MathAlgorithms.isPrime(4));
    }

    @Test
    public void numberIsLessThanOneShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(-1));
        assertEquals("A szám nem nagyobb nullánál!", ex.getMessage());
    }
}
