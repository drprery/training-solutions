package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {
    public List<Integer> createList(int... numbers){
        List<Integer> nums = new ArrayList<>();

        for(int num : numbers){
            nums.add(num);
        }
        return nums;
    }

    public int sumIntegerList(List<Integer> integerList){
        int sum=0;

        for(Integer i : integerList){
            sum+=i;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers){
        int sum=0;

        for(Integer i : integers){
            sum+=i;
        }
        return sum;
    }
}
