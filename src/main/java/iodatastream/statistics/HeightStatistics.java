package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> bodyHeights, Path path) {

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            dos.writeInt(bodyHeights.size());

            for (Integer height : bodyHeights) {
                dos.writeInt(height);
            }
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
