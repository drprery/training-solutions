package interfaceextends.robot;

import java.util.List;

public interface MoveableRobot {
    void moveTo(Point positon);
    void fastMoveTo(Point position);
    void rotate(int angle);
    List<Point> getPath();
}
