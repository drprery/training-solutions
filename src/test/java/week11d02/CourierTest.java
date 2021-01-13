package week11d02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void testCourierWrongDay() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(1, 3, 20)));
    }

    @Test
    void testCourierWrongNumberOfRoad() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(2, 3, 20)));
    }

    @Test
    void testCourierOffDay() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(1, 2, 20));
        c.addRide(new Ride(2, 1, 20));
        c.addRide(new Ride(4, 1, 20));
        c.addRide(new Ride(4, 2, 20));
        assertEquals(3, c.firstOffDay());
    }

    @Test
    void testNoCourierOffDay() {
        Courier c = new Courier();
        c.addRide(new Ride(1, 1, 20));
        c.addRide(new Ride(2, 1, 20));
        c.addRide(new Ride(3, 1, 20));
        c.addRide(new Ride(4, 1, 20));
        c.addRide(new Ride(5, 1, 20));
        c.addRide(new Ride(6, 1, 20));
        c.addRide(new Ride(7, 1, 20));
        assertEquals(-1, c.firstOffDay());
    }
}