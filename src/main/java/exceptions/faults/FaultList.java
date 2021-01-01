package exceptions.faults;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FaultList {
    public List<String> processLines(List<String> lines){
        List<String> result=new ArrayList<>();

        if(lines==null){
            throw new IllegalArgumentException();
        }

        for(String line:lines){
            if(!(processLine(line)==0)){
                result.add(line.substring(0, line.indexOf(",")+1)+processLine(line));
            }
        }
        return result;
    }

    private int processLine(String line) {
        String[] lines = line.split(",");
        int errorCode = 0;

        try{
            Integer.parseInt(lines[0]);
        } catch (NumberFormatException nfe){
            return 0;
        }

        if (lines.length > 3) {
            errorCode = ProcessingResult.WORD_COUNT_ERROR.getCode();
        }

        try {
            Double.parseDouble(lines[1]);
        } catch (NumberFormatException nfe) {
            errorCode += ProcessingResult.VALUE_ERROR.getCode();
        }

        try {
            DateTimeFormatter formatter;

            if(lines[2].length()==11) {
                formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
            } else {
                formatter = DateTimeFormatter.ofPattern("yyyy.MM.d.");
            }

            LocalDate.parse(lines[2], formatter);
        } catch (DateTimeParseException dtpe) {
            errorCode += ProcessingResult.DATE_ERROR.getCode();
        }

        return errorCode;
    }
}
