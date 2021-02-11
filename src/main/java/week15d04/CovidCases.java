package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidCases {
    public String[] readHungary(){
        try(InputStream is = CovidCases.class.getResourceAsStream("data.csv")){
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            String[] lineArr = {};
            while((line=br.readLine())!=null){
                lineArr = line.split(",");
                if(lineArr[4].equals("Hungary")){
                    break;
                }
            }

            int cases = Integer.parseInt(lineArr[2]);
            String date = lineArr[1];
            List<Data> caseList = new ArrayList<>();
            caseList.add(new Data(cases, date));
            String[] threeMaxCases =  new String[3];

            while((line=br.readLine())!=null){
                lineArr = line.split(",");
                if(lineArr[4].equals("Hungary")){
                    caseList.add( new Data(Integer.parseInt(lineArr[2]), lineArr[1]));
                }
            }
            Collections.sort(caseList);
            Collections.reverse(caseList);

            threeMaxCases[0]=caseList.get(0).getYearAndWeek();
            threeMaxCases[1]=caseList.get(1).getYearAndWeek();
            threeMaxCases[2]=caseList.get(2).getYearAndWeek();

            return threeMaxCases;

        } catch (IOException ioe){
            throw new IllegalStateException("File not found!");
        }
    }

    public static void main(String[] args) {
        CovidCases covidCases = new CovidCases();

        String[] result = covidCases.readHungary();
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
    }
}
