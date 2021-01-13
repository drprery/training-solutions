package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {
    public WordFilter() {
    }

    public List<String> wordsWithChar(List<String> words, char c){
        List<String> filtered = new ArrayList<>();

        for(String word : words){
            if(word.contains(""+c)){
                filtered.add(word);
            }
        }
        return filtered;
    }
}
