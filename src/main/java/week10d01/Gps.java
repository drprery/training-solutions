package week10d01;

public class Gps {
    private double latitude;
    private double longitude;
    private double height;

    public Gps(double latitude, double longitude, double height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getHeight() {
        return height;
    }
}
