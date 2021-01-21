package ioreadbytes.byteacount;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStream;

public class ByteChecker {

    public int readBytesAndFindAs(String file){
        Path path = Path.of(file);
        int sum =0;

        try(InputStream is = Files.newInputStream(path)){
            int blockSize = 0;
            byte[] buffer = new byte[1000];

            while((blockSize = is.read(buffer)) > 0){
                for(byte b : buffer){
                    if(b == 97){
                        sum++;
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return sum;
    }
}
