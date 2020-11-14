package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    private List<Integer> elements = new ArrayList<>();

    public Duplicates(List<Integer> elements) {
        this.elements = elements;
    }

    public List<Integer> findDuplicates() {
        List<Integer> duplicates = new ArrayList<>();

        int index=1;
        int item=0;
        //for (Integer item : elements) {
        for(int i=1;i<elements.size();i++){
            item=elements.get(i);
            if(elements.subList(0,index).contains(item)){
                if(!duplicates.contains(item)) {
                    duplicates.add(item);
                }
            }
            index++;
        }
        return duplicates;
    }
}
