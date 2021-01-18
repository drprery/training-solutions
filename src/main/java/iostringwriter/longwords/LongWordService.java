package iostringwriter.longwords;

import java.io.Writer;
import java.util.List;
import java.io.PrintWriter;
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
        PrintWriter pw=new PrintWriter(writer);

        for(String s:longWords){
            pw.print(s);
            pw.print(":");
            pw.println(s.length());
        }
    }




}