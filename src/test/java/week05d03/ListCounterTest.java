package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {
    @Test
    public void givenCharIsFound(){
        ListCounter listCounter=new ListCounter();

        assertEquals(1,listCounter.countOfA(new ArrayList<String>(List.of("Alma","Körte","Barack"))));
        assertEquals(2,listCounter.countOfA(new ArrayList<String>(List.of("Alma","Körte","ananász"))));
    };

    @Test
    public void givenCharIsNotFound(){
        ListCounter listCounter=new ListCounter();

        assertEquals(0,listCounter.countOfA(new ArrayList<String>(List.of("Narancs","Körte","Barack"))));
    }

    @Test
    public void searchedListIsEmpty(){
        ListCounter listCounter=new ListCounter();

        assertEquals(0,listCounter.countOfA(new ArrayList<String>()));
    }
}
