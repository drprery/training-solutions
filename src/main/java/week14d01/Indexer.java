package week14d01;

import java.util.*;

public class Indexer {
    public Map<Character, List<String>> index(List<String> names){
        Map<Character, List<String>> mapNames = new TreeMap<>();


        for(String name : names){
            char firstC=name.charAt(0);

            if(mapNames.get(firstC)==null){
                List<String> nameList = new ArrayList<>();
                nameList.add(name);
                mapNames.put(firstC, nameList);
            } else {
                List<String> nameList = new ArrayList<>();
                nameList=mapNames.get(firstC);
                nameList.add(name);
                mapNames.put(firstC, nameList);
            }
        }
        return mapNames;
    }

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Antal")));
    }
}
