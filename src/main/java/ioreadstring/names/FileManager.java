package ioreadstring.names;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path fileName;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        fileName = Path.of(path);
    }

    public void readFromFile() {
        List<String> names = new ArrayList<>();

        try {
            names = Files.readAllLines(fileName);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!", ioe);
        }

        for (String name : names) {
            humans.add(new Human(name.substring(0, name.indexOf(" ")), name.substring(name.indexOf(" ") + 1)));
        }
    }

    public Path getFileName(Path path) {
        return path.getFileName();
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }

    public Path getMyFile() {
        return fileName;
    }
}
