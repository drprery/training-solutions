package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Battles {
    private  Map<String, Integer> houses = new HashMap<>();

    public Battles(){
        try (InputStream is = Battles.class.getResourceAsStream("battles.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))){

            processLines(br);
        } catch (IOException ioe){
            throw new IllegalStateException("File not found!");
        }
    }

    private void processLines(BufferedReader br){
        String line;
        try{
            while((line=br.readLine())!=null){
                String[] lines = line.split(",");
                for(int i = 5; i<13; i++){
                    if(lines[i]!=null && lines[i]!=""){
                        if(!houses.containsKey(lines[i])){
                            houses.put(lines[i], 0);
                        }
                        int battleNumber = houses.get(lines[i]);
                        houses.put(lines[i], ++battleNumber);
                    }
                }
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Can't read file!");
        }
    }

    public String houseWithMaxNumberOfBattles(){
        int maxBattle = 0;
        String houseName = "";
        for(String key : houses.keySet()){
            if(houses.get(key)>maxBattle){
                maxBattle = houses.get(key);
                houseName = key;
            }
        }
        return houseName+" "+maxBattle;
    }

    public static void main(String[] args) {
        Battles battles = new Battles();

        System.out.println(battles.houseWithMaxNumberOfBattles());
    }
}
