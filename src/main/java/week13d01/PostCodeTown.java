package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostCodeTown {
    public static void main(String[] args) {
        String line=null;
        String[] lineSeg;
        List<String> reverseOrder = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(PostCodeTown.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")))) {
            line=bf.readLine();
            while((line=bf.readLine())!=null){
                lineSeg=line.split(";");
                reverseOrder.add(lineSeg[1]+";"+lineSeg[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(reverseOrder);
        System.out.println(reverseOrder.get(0).split(";")[1]+" "+reverseOrder.get(0).split(";")[0]);
    }
}
