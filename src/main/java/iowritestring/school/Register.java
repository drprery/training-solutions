package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {
    public void newMark(Path path, int mark) {
        if (Files.exists(path)) {
            try {
                Files.writeString(path, mark + "\n", StandardOpenOption.APPEND);
            } catch (IOException ioe) {
                throw new IllegalStateException("File writing error: !", ioe);
            }
        } else {
            try {
                Files.writeString(path, ""+mark);
            } catch (IOException ioe) {
                throw new IllegalStateException("File writing error: !", ioe);
            }
        }
    }
    public void average(Path path) {
        double average = 0;

        try {
            List<String> marks = Files.readAllLines(path);
            for (String mark: marks) {
                average += Integer.parseInt(mark);
            }
            average = average / marks.size();
            Files.writeString(path, "average: " + average, StandardOpenOption.APPEND);
        } catch (IOException ioe) {}
    }
}
