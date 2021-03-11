package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {
    public List<String> getStationsInStorm(BufferedReader reader){
        String line;
        String allomas;
        int level;

        List<String> stations = new ArrayList<>();

        try{
            while((line=reader.readLine())!=null){
                if(line.contains("allomas")){
                    allomas=line.substring(line.indexOf(": ")+3,line.length()-2);
                    line = skipLines(reader);
                    level=Integer.parseInt(line.substring(line.indexOf(": ")+2,line.length()-1));
                    if(level>=3){
                        stations.add(allomas);
                    }
                }
            }
        } catch (IOException ioe){
            throw new IllegalStateException();
        }

        Collator huCollator = Collator.getInstance(new Locale("HU","hu"));
        huCollator.setStrength(Collator.PRIMARY);
        Collections.sort(stations, huCollator);

        return stations;
    }

    private String skipLines(BufferedReader reader) throws IOException {
        String line = null;

        for(int i=1; i<=4; i++){
            line = reader.readLine();
        }

        return line;
    }
}
