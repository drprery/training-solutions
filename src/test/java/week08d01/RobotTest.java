package week08d01;

import org.junit.jupiter.api.Test;
import week07d01.MathAlgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {
    @Test
    public void testRobot() {
        Robot robot = new Robot();
        Coords coords = new Coords();

        coords = robot.move("JJJFFF");
        assertEquals(3, coords.getX());
        assertEquals(3, coords.getY());
    }

    @Test
    public void testWrongRobotDirections() throws IllegalArgumentException {
        Robot robot = new Robot();
        Coords coords = new Coords();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> robot.move("JJJRFFF"));
        assertEquals("Hibás iránymegadás!", ex.getMessage());
    }
}
