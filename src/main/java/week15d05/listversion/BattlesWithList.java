package week15d05.listversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class BattlesWithList {
    private List<House> houses = new ArrayList<>();
    private Map<String, Integer> houseMap = new HashMap<>();

    public BattlesWithList(){
        try (InputStream is = week15d05.Battles.class.getResourceAsStream("battles.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))){

            processLines(br);
        } catch (IOException ioe){
            throw new IllegalStateException("File not found!");
        }
    }

    private void processLines(BufferedReader br){
        String line;
        int houseNumber = 0;

        try{
            line=br.readLine();
            while((line=br.readLine())!=null){
                String[] lines = line.split(",");
                for(int i = 5; i<13; i++){
                    if(lines[i]!=null && lines[i]!=""){
                        if(!houses.contains(new House(lines[i], 0))){
                            houses.add(new House(lines[i], 0));
                            houseMap.put(lines[i], houseNumber++);
                        }
                        House house = houses.get(houseMap.get(lines[i]));
                        house.setNumberOfBattles(house.getNumberOfBattles()+1);
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

        Collections.sort(houses);
        Collections.reverse(houses);
        return houses.get(0).getName()+" "+houses.get(0).getNumberOfBattles();
    }

    public static void main(String[] args) {
        week15d05.listversion.BattlesWithList battles = new week15d05.listversion.BattlesWithList();

        System.out.println(battles.houseWithMaxNumberOfBattles());
    }
}
