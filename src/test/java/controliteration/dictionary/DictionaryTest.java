package controliteration.dictionary;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DictionaryTest {

    @Test
    public void shouldFind() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("macska", List.of("persian", "cat"));

        List<String> translations = dictionary.findTranslations("macska");
        assertEquals(List.of("persian", "cat"), translations);
    }

    @Test
    public void append() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("macska", List.of("persian", "cat"));
        dictionary.addItem("macska", List.of("siamese"));

        List<String> translations = dictionary.findTranslations("macska");

        assertEquals(List.of("persian", "cat", "siamese"), translations);
    }

    @Test
    public void appendOnce() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("macska", List.of("persian", "cat"));
        dictionary.addItem("macska", List.of("siamese"));
        dictionary.addItem("macska", List.of("siamese"));

        List<String> translations = dictionary.findTranslations("macska");

        assertEquals(List.of("persian", "cat", "siamese"), translations);
    }
}
