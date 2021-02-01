package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {
    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        Set<String> filteredStrings = new HashSet<>();

        for(String str : stringCollection){
            filteredStrings.add(str);
        }
        return filteredStrings;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
        Set<String> identicalStrings = new HashSet<>();

        for(String str : setA){
            identicalStrings.add(str);
        }
        for(String str : setB){
            identicalStrings.add(str);
        }
        return identicalStrings;
    }
}
