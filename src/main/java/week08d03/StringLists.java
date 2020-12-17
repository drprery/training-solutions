package week08d03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringLists {
    public static Set<String> stringListsUnion(List<String> first, List<String> second){
        Set<String> union=new HashSet<>();

        for(String s:first){
            union.add(s);
        }
        for(String s:second){
            union.add(s);
        }
        return union;
    }
}
