package week07d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberList {
    List<Integer> list2;

    public boolean isIncreasing(List<Integer> list) {
        list2 = new ArrayList<>(list);

        Collections.sort(list2);
        if (list.equals(list2)) {
            return true;
        }
        return false;
    }
}
