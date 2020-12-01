package week06d01;

import org.junit.jupiter.api.Test;
import week05d02.ChangeLetter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    public void testListSelectorIsNull(){
        List<String> list=null;

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ListSelector(list).concatEvenStrings());
        assertEquals("Üres a lista!", ex.getMessage());
    }

    @Test
    public void testListIsEmpty(){
        List<String> list=new ArrayList<>();

        assertEquals("",new ListSelector(list).concatEvenStrings());
    }

    @Test
    public void testListIsNotEmpty(){
        List<String> list=new ArrayList<>(List.of("Egy","Kettő","Három","Négy","Öt"));

        assertEquals("[Kettő][Négy]",new ListSelector(list).concatEvenStrings());
    }
}
