package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot{
    private Point position;
    private int angle;
    List<Point> path=new ArrayList<>();

    public C3PO(Point position){
        this.position=position;
    }

    public void moveTo(Point position){
        walkTo(position);
    }

    public void fastMoveTo(Point position){
        walkTo(position);
    }
    public void rotate(int angle){
        this.angle=angle;
    }

    private void walkTo(Point position){
        this.position=position;
        path.add(position);
    }

    public int getAngle() {
        return angle;
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }
}
