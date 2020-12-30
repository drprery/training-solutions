package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot{
    private Point position;
    private int angle;
    List<Point> path=new ArrayList<>();

    static long ALTITUDE=5; //???

    public AstroBoy(Point position){
        this.position=position;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return ALTITUDE;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public void walkTo(Point position){
        this.position=position;
        path.add(position);
    }

    public void flyTo(Point position){
        path.add(new Point(getPosition().getX(),getPosition().getY(),getAltitude()));
        path.add(new Point(position.getX(),position.getY(),getAltitude()));
        path.add(new Point(position.getX(),position.getY(),0));
        this.position=new Point(position.getX(), position.getY(), 0);
    }

    public void liftTo(long altitude){
        this.ALTITUDE=altitude;
    }

    public void moveTo(Point position){
        walkTo(position);
    }

    public void fastMoveTo(Point position){
        flyTo(position);
    }

    public void rotate(int angle){
        this.angle=angle;
    }
}
