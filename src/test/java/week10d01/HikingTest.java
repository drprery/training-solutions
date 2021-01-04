package week10d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikingTest {
    @Test
    public void testHiking() {
        List<Gps> data = new ArrayList<>(List.of(new Gps(47.497913, 19.040236, 400.0), new Gps(47.497912, 19.040232, 420.0), new Gps(47.497916, 19.040236, 410.0)));

        assertEquals(20, new Hiking().getPlusElevation(data));
    }
}
