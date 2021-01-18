package week12d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeRounderTest {
    @Test
    public void testGradesArray(){
        int[] grades = new int[]{3, 5, 13, 41, 43, 49, 50};
        int[] roundedGrades = new int[grades.length];
        GradeRounder gradeRounder = new GradeRounder();

        roundedGrades = gradeRounder.roundGrades(grades);
        assertEquals(3, roundedGrades[0]);
        assertEquals(5, roundedGrades[1]);
        assertEquals(13, roundedGrades[2]);
        assertEquals(41, roundedGrades[3]);
        assertEquals(45, roundedGrades[4]);
        assertEquals(50, roundedGrades[5]);
        assertEquals(50, roundedGrades[6]);
    }

}
