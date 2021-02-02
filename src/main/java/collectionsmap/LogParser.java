package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {
    public Map<String, List<Entry>> parseLog(String log){
        Map<String, List<Entry>> logMap = new HashMap<>();
        String[] logLines = log.split("\n");
        String[] logFields;
        LocalDate logDate;
        List<Entry> tmpEntryList = new ArrayList<>();

        for(String logLine : logLines){
            logFields=logLine.split(":");

            if(logFields.length<3){
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }

            try{
                logDate=LocalDate.parse(logFields[1]);
            } catch (DateTimeParseException dtpe){
                throw new IllegalArgumentException("Incorrect log: incorrect date");
            }

            Entry entry = new Entry(logFields[0], logFields[2], logDate);
            if(logMap.containsKey(logFields[0])){
                tmpEntryList=logMap.get(logFields[0]);
                tmpEntryList.add(entry);
                logMap.put(logFields[0],tmpEntryList);
            } else {
                tmpEntryList.add(entry);
                logMap.put(logFields[0],tmpEntryList);
            }
        }
        return logMap;
    }
}
