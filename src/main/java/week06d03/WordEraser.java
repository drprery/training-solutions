package week06d03;

import java.util.ArrayList;
import java.util.List;

public class WordEraser {

    public String eraseWords(String words, String word){
        List<String> strings=new ArrayList<>(List.of(words.split(" ")));


        strings.removeAll(List.of(word));
        String[] newStrings=strings.toArray(new String[0]);
        return String.join(" ",newStrings);
    }
}
