package week05d02;

import org.junit.jupiter.api.Test;
import stringscanner.StringScanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeLetterTest {
    @Test
    public void correctStringIsPassed(){
        ChangeLetter changeLetter=new ChangeLetter();

        assertEquals("*****",changeLetter.changeVowels("aeiou"));
        assertEquals("str*ng",changeLetter.changeVowels("string"));
        assertEquals("n*t *n *rr*r",changeLetter.changeVowels("not an error"));
    }

    @Test
    public void parameterIsNullShouldThrowException() throws IllegalArgumentException {
        ChangeLetter changeLetter=new ChangeLetter();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ChangeLetter().changeVowels(null));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }
}
