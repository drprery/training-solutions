package week07d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberListTest {
    @Test
    public void numbersIsIncreasing() {
        NumberList numberList = new NumberList();

        assertEquals(true, numberList.isIncreasing(List.of(1, 2, 3, 3, 6, 7)));
    }

    @Test
    public void numbersIsNotIncreasing() {
        NumberList numberList = new NumberList();

        assertEquals(false, numberList.isIncreasing(List.of(1, 2, 6, 7, 3)));
    }
}
