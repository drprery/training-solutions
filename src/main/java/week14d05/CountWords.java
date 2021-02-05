package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountWords {
    public Map<String, Integer> countWords(String... words){
        Map<String, Integer> wordsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(CountWords.class.getResourceAsStream("hachiko.srt")))) {
            String line;

            while((line=br.readLine())!=null){
                for(String word : words){
                    if(line.contains(word)){
                        if( wordsMap.get(word)==null) {
                            wordsMap.put(word, 1);
                        } else {
                            wordsMap.put(word,wordsMap.get(word)+1);
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!", ioe);
        }

        return wordsMap;
    }

    public static void main(String[] args) {
        CountWords countWords = new CountWords();

        System.out.println(countWords.countWords("Hachiko","haza","pályaudvar","jó","Hachi"));
    }
}
