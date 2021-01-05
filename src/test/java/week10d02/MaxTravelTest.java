package week10d02;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {
        assertEquals(8, new MaxTravel().getMaxIndex(List.of(8, 8, 8, 0, 3, 4)));
        assertEquals(1, new MaxTravel().getMaxIndex(List.of(1, 1, 1, 3, 4, 4)));
        assertEquals(10, new MaxTravel().getMaxIndex(List.of(10)));
        assertEquals(8, new MaxTravel().getMaxIndex(List.of(8, 8, 0, 3, 4, 4, 8)));
    }

    @Test
    void getMaxIndexNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MaxTravel().getMaxIndex(null));
    }

    @Test
    void getMaxIndexEmpty() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MaxTravel().getMaxIndex(List.of()));
    }

    @Test
    void getMaxIndexTooManyStops() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new MaxTravel().getMaxIndex(List.of(12, 12, 0, 3, 4, 4, 30)));
    }
}