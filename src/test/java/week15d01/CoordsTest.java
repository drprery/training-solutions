package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordsTest {
    @Test
    public void testCoords(){
        Map<Integer, Integer> coordMap = new HashMap<>();
        coordMap.put(1, 2);
        coordMap.put(2, 5);
        coordMap.put(5, 1);
        coordMap.put(4, 5);
        coordMap.put(3, 6);

        Coords coords = new Coords(coordMap);

        assertEquals("3, 6", coords.maxY());
    }
}
