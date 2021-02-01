package collectionsset.collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {
    public Set<String> filterWords(String[] randomStrings){
        Set<String> filteredWords = new TreeSet<>();

        for(String randomString : randomStrings){
            filteredWords.add(randomString);
        }
        return filteredWords;
    }
}
