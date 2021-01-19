package iowriter.music;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands = new ArrayList<>();
    private List<String> bandLines = new ArrayList<>();

    public void readBandsFromFile(Path path){
        try {
            bandLines= Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String bandLine : bandLines){
            bands.add(new Band(bandLine.substring(0, bandLine.length()-5), Integer.parseInt(bandLine.substring(bandLine.length()-4,bandLine.length()))));
        }
    }

    public void writeBandsBefore(Path path, int year){
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            for(Band band : bands){
                if(band.getYear()<year){
                    bw.write(band.getName()+"\n");
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException();
        }
    }
}
