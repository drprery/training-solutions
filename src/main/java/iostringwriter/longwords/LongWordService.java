package iostringwriter.longwords;

import java.io.Writer;
import java.util.List;
import java.io.StringWriter;
import java.io.IOException;

public class LongWordService {

    public String writeWithStringWriter(List<String> longWords){
        StringWriter sw=new StringWriter();

        try(sw){
            longWordProcess(sw,longWords);
            return sw.toString();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    public void longWordProcess(Writer writer, List<String> longWords){

        for(String s:longWords){
            try {
                writer.write(s);
                writer.write(":");
                writer.write(s.length()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}