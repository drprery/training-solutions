package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {
    public String createHistogram(BufferedReader reader) {
        StringBuilder starLine = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                starLine.append("*".repeat(Integer.parseInt(line))).append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!");
        }

        return starLine.toString();
    }
}
