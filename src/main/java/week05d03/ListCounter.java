package week05d03;

import java.util.List;

public class ListCounter {
    public int countOfA(List<String> words){
        int count=0;
        char letter=' ';

        for(String word:words){
            letter=word.charAt(0);
            if(letter=='A' || letter=='a'){
                count++;
            }
        }
        return count;
    }
}
