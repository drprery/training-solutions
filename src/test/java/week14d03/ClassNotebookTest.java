package week14d03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ClassNotebookTest {
    @Test
    public void testNotebook(){
        Student student = new Student("Kovacs Jozsef");
        student.setMark("Matematika", 4);
        student.setMark("Matematika", 2);
        student.setMark("Történelem", 5);
        student.setMark("Fizika", 2);
        student.setMark("Történelem", 4);

        Student student2 = new Student("Kovacs Janos");
        student2.setMark("Matematika", 2);
        student2.setMark("Matematika", 1);
        student2.setMark("Történelem", 3);
        student2.setMark("Fizika", 2);
        student2.setMark("Történelem", 2);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);

        ClassNotebook classNotebook = new ClassNotebook(new ArrayList<>(students));

        students = classNotebook.sortNotebook();
        assertEquals("Kovacs Janos", students.get(0).getName());
    }

}
