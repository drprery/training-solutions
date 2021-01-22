package week12d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CovidCount {
    public static void main(String[] args) {
        List<String> lines;
        int count = 0;

        try{
            lines = Files.readAllLines(Path.of("Index.html"));
            for(String line : lines){
                if(line.toLowerCase().contains("koronavírus")){
                    count++;
                }
            }
            System.out.println("The number of lines: "+count);
        } catch (IOException ioe) {
            throw new IllegalStateException();
        }
    }
}
