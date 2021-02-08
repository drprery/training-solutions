package week15d01;

import java.util.*;

public class Coords {
    private Map<Integer, Integer> coords;

    public Coords(Map<Integer, Integer> coords){
        this.coords = coords;
    }

    public String maxY(){
        Set<Integer> x = new TreeSet<>();

        x = coords.keySet();
        Iterator<Integer> it = x.iterator();

        Integer xPos = it.next();
        Integer maximumY = coords.get(xPos);

        while(it.hasNext()){
             if(maximumY<coords.get(it.next())){
                 xPos = it.next();
                 maximumY = coords.get(xPos);
             }
        }
        return ""+xPos+", "+maximumY;
    }
}
