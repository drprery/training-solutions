package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teacher {

    public int teacherHour(String name) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Teacher.class.getResourceAsStream("beosztas.txt")))) {
            String line;
            int hours = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains(name)) {
                    reader.readLine();
                    reader.readLine();
                    hours += Integer.parseInt(reader.readLine());
                }
            }

            if (hours == 0){
                throw new IllegalArgumentException("Teacher not found");
            }

            return hours;

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

}
