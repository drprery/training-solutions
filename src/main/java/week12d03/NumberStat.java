package week12d03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStat {
    private List<Integer> numbers= new ArrayList<>();

    public int soleNumber(){
        readNumbers();

        if(numbers.size()==0){
            throw new IllegalArgumentException();
        }

        List<Integer> retNumbers = new ArrayList<>();
        Collections.sort(numbers);
        int count=1;
        for(int i=1;i<numbers.size();i++){
            if(numbers.get(i)==numbers.get(i-1)){
                count++;
                continue;
            }
            if(count==1){
                retNumbers.add(numbers.get(i-1));
            } else {
                count=1;
            }
        }
        if(count==1){
            retNumbers.add(numbers.get(numbers.size()-1));
        }
        Collections.sort(retNumbers);
        return retNumbers.get(0);
    }

    private void readNumbers(){
        List<String> numberLines;

        try{
            numberLines= Files.readAllLines(Path.of("src/test/resources/week12d03/numbers.txt"));
        } catch (IOException ioe){
            throw new IllegalStateException("File not found!", ioe);
        }

        for(String numberLine : numberLines){
            String[] numberLineElements = numberLine.split(",");
            for(String num : numberLineElements){
                numbers.add(Integer.parseInt(num));
            }
        }
    }
}
