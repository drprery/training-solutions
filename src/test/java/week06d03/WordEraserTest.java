package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordEraserTest {
    @Test
    public void testWordIsInString(){
        WordEraser wordEraser=new WordEraser();

        assertEquals("Volt nincs",wordEraser.eraseWords("Volt nincs szó","szó"));
    }
}
