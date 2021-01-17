package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    private List<String> ids = new ArrayList<>();

    public List<String> getIds() {
        return ids;
    }

    public void readIdsFromFile(String file){
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))){
            String line="";
            while(((line=br.readLine())!=null)){
                ids.add(line);
            }
        } catch (IOException ioe){
            throw new IllegalStateException();
        }
    }
}
