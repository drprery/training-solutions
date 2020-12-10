package abstractclass.gamecharacter;

public class Point {
    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long distance(Point otherPoint) {
        return (long) Math.sqrt(Math.pow((double)x - otherPoint.getX(), 2) + Math.pow((double)y - otherPoint.getY(), 2));
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
