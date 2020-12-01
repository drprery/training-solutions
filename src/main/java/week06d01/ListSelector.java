package week06d01;

import java.util.ArrayList;
import java.util.List;

public class ListSelector {
    private List<String> strings;

    public ListSelector(List<String> strings){
        if(strings==null){
            throw new IllegalArgumentException("Üres a lista!");
        }
        this.strings=new ArrayList<>(strings);
    }
    public String concatEvenStrings(){
        StringBuilder sb=new StringBuilder("");

        if(strings.size()==0){
            return "";
        }

        for(int i=1;i< strings.size();i+=2){
            sb.append("["+strings.get(i)+"]");
        }
        return sb.toString();
    }
}
