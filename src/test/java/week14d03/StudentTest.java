package week14d03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void testStudent(){
        Student student = new Student("Kovács József");
        student.setMark("Matematika", 4);
        student.setMark("Matematika", 2);
        student.setMark("Történelem", 5);
        student.setMark("Fizika", 2);
        student.setMark("Történelem", 4);

        assertEquals("Kovács József", student.getName());
        assertEquals("[4, 2]", student.getMarks().get("Matematika").toString());
    }
}
