package week11d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFilterTest {
    @Test
    public void testFilteredList(){
        WordFilter wordFilter = new WordFilter();
        List<String> words = new ArrayList<>(List.of("Eee","Kke","Hhh"));
        List<String> filteredWords = wordFilter.wordsWithChar(words, 'e');

        assertEquals("Eee", filteredWords.get(0));
        assertEquals("Kke", filteredWords.get(1));
    }
}
