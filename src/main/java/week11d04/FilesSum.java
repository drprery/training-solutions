package week11d04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {
    public int sumNumbers(){
        int sum = 0;
        String line="";
        String fileName="";

        for(int i=0;i<100;i++){
            fileName = "number"+(i<10?"0"+i+".txt":i+".txt");

            if(Files.isRegularFile(Path.of(fileName))){
                try {
                    line = Files.readString(Path.of(fileName));
                } catch (IOException ioe) {
                    throw new IllegalStateException();
                }

                sum+=Integer.parseInt(line);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        InputStream is = FilesSum.class.getResourceAsStream("/");
        FilesSum filesSum = new FilesSum();

        System.out.println(filesSum.sumNumbers());
    }
}
