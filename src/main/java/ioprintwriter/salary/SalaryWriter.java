package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file){

        try (PrintWriter pr = new PrintWriter(Files.newBufferedWriter(file))){
            for(String name : names){
                if(name.contains("Dr")){
                    pr.print(name+": ");
                    pr.println(500000);
                    continue;
                }
                if(name.contains("Mr") || name.contains("Mrs")){
                    pr.print(name+": ");
                    pr.println(200000);
                    continue;
                }
                pr.print(name+": ");
                pr.println(100000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
