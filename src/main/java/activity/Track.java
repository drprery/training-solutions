package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints=new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint){
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate(){
        double latitude=Double.MIN_VALUE;
        double longitude=Double.MIN_VALUE;

        for(TrackPoint trackPoint : trackPoints){
            if(trackPoint.getCoordinate().getLatitude()>latitude){
                latitude=trackPoint.getCoordinate().getLatitude();
            }

            if(trackPoint.getCoordinate().getLongitude()>longitude){
                longitude=trackPoint.getCoordinate().getLongitude();
            }
        }

        return new Coordinate(latitude, longitude);
    }

    public Coordinate findMinimumCoordinate(){
        double latitude=Double.MAX_VALUE;
        double longitude=Double.MAX_VALUE;

        for(TrackPoint trackPoint : trackPoints){
            if(trackPoint.getCoordinate().getLatitude()<latitude){
                latitude=trackPoint.getCoordinate().getLatitude();
            }

            if(trackPoint.getCoordinate().getLongitude()<longitude){
                longitude=trackPoint.getCoordinate().getLongitude();
            }
        }

        return new Coordinate(latitude, longitude);
    }

    public double getDistance(){
        TrackPoint prevTrackPoint=trackPoints.get(0);
        double distance=0.0;

        for(int i=1;i<trackPoints.size();i++){
            distance+=trackPoints.get(i).getDistanceFrom(prevTrackPoint);
            prevTrackPoint=trackPoints.get(i);
        }

        return distance;
    }

    public double getFullDecrease(){
        double decrease=0.0;
        double prevAltitude=trackPoints.get(0).getElevation();

        for(int i=1;i<trackPoints.size();i++){
            if(prevAltitude>trackPoints.get(i).getElevation()){
                decrease+=(prevAltitude-trackPoints.get(i).getElevation());
            }
            prevAltitude=trackPoints.get(i).getElevation();
        }

        return decrease;
    }

    public double getFullElevation(){
        double elevation=0.0;
        double prevElevation=trackPoints.get(0).getElevation();

        for(int i=1;i<trackPoints.size();i++){
            if(prevElevation<trackPoints.get(i).getElevation()){
                elevation+=(trackPoints.get(i).getElevation()-prevElevation);
            }
            prevElevation=trackPoints.get(i).getElevation();
        }

        return elevation;
    }

    public double getRectangleArea(){
        double latLength=0.0;
        double longLength=0.0;

        latLength=(Math.abs(findMinimumCoordinate().getLatitude())+Math.abs(findMaximumCoordinate().getLatitude()));
        longLength=(Math.abs(findMinimumCoordinate().getLongitude())+Math.abs(findMaximumCoordinate().getLongitude()));

        return latLength*longLength;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void loadFromGpx(InputStream is){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            String newLine;
            double lat=0.0;
            double lon=0.0;
            double ele=0.0;

            while((line = reader.readLine()) != null) {
                if(line.contains("<trkpt")){
                    lat=Double.parseDouble(line.substring(line.indexOf("lat="+5),line.indexOf("lat=")+15));
                    lon=Double.parseDouble(line.substring(line.indexOf("lon="+5),line.indexOf("lon=")+15));
                    newLine=reader.readLine();
                    ele=Double.parseDouble(newLine.substring(newLine.indexOf("<ele")+5,newLine.indexOf("<ele")+10));
                    trackPoints.add(new TrackPoint(new Coordinate(lat, lon), ele));
                }

            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
