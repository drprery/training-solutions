package week12d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStat {
    public int soleNumber(List<Integer> numbers){
        if(numbers.size()==0){
            throw new IllegalArgumentException();
        }

        List<Integer> retNumbers = new ArrayList<>();
        Collections.sort(numbers);
        int count=1;
        for(int i=1;i<numbers.size();i++){
            if(numbers.get(i)==numbers.get(i-1)){
                count++;
                continue;
            }
            if(count==1){
                retNumbers.add(numbers.get(i-1));
            } else {
                count=1;
            }
        }
        if(count==1){
            retNumbers.add(numbers.get(numbers.size()-1));
        }
        Collections.sort(retNumbers);
        return retNumbers.get(0);
    }
}
