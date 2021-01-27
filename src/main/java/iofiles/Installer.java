package iofiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Installer {
    private String source = "/install/";

    public void install(String path) {
        Path destination = Path.of(path);

        if (!Files.exists(destination) || !Files.isDirectory(destination)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Installer.class.getResourceAsStream("/install/install.txt")))) {
            String line="";

            while ((line = br.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(destination.resolve(line));
                } else {
                    Files.copy(Installer.class.getResourceAsStream(source + line), destination.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot copy files.", ioe);
        }
    }
}
