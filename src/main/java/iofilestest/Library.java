package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books=new ArrayList<>();

    public void add(Book book){
        books.add(book);
    }

    public void saveBooks(Path path){
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            for(Book book:books){
                bw.write(book.getAuthor()+";"+book.getTitle());
            }
        } catch (IOException ioe){
            throw new IllegalStateException("File couldn't be created!", ioe);
        }
    }

    public void loadBooks(Path path){
        try(BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while((line=br.readLine())!=null){
                books.add(new Book(line.split(";")[0],line.split(";")[1]));
            }
        } catch (IOException ioe){
            throw new IllegalStateException("File couldn't be read!", ioe);
        }
    }
}
