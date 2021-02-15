package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VowelFilter {
    public String filterFowels(BufferedReader reader){
        String line;
        StringBuilder sb = new StringBuilder();

        try{
            while((line=reader.readLine())!=null){
                String[] chars = line.split("");
                for(String s : chars){
                    if(!"aáeáiíuúüűoóöőAÁEÉIÍUÚÜŰOÓÖŐ".contains(s)){
                        sb.append(s);
                    }
                }
                sb.append("\n");
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file!");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        VowelFilter vowelFilter = new VowelFilter();

        try(InputStream is = VowelFilter.class.getResourceAsStream("words.txt")){
            System.out.println(vowelFilter.filterFowels(new BufferedReader(new InputStreamReader(is))));
        } catch (IOException ioe){
            throw new IllegalStateException("File not found!");
        }

    }
}
