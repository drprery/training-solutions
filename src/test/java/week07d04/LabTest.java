package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabTest {
    @Test
    public void exerciseIsDone(){
        Lab lab=new Lab("matematika",2020,12,10,11,59);

        assertEquals("A matematika feladat el lett végezve: 2020-12-10T11:59",lab.toString());
    }

    @Test
    public void exerciseIsCompletedLater(){
        Lab lab=new Lab("matematika");
        lab.complete(2020,12,10,11,59);

        assertEquals("A matematika feladat el lett végezve: 2020-12-10T11:59",lab.toString());
    }

    @Test
    public void exerciseIsNotDone(){
        Lab lab=new Lab("matematika");

        assertEquals("A matematika feladat még nincs elvégezve!",lab.toString());
    }
}
