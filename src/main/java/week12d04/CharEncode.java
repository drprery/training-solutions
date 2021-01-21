package week12d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CharEncode {
    public static void main(String[] args) {
        try {
            byte[] codes = Files.readAllBytes(Path.of("secret.dat"));
            for(int i=0;i<codes.length;i++){
                codes[i]+=10;
                System.out.print((char) codes[i]);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!", ioe);
        }
    }

}
