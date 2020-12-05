package week06d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart sc;

    @BeforeEach
    void createItemList() {
        sc = new ShoppingCart();

        sc.addItem("First", 3);
        sc.addItem("Second", 4);
        sc.addItem("Third", 6);
        sc.addItem("First", 3);
    }

    @Test
    void testNameIsNull() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> sc.addItem(null, 1));
        assertEquals("The name must not be empty!", ex.getMessage());
    }

    @Test
    void testNameIsEmpty() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> sc.addItem("", 1));
        assertEquals("The name must not be empty!", ex.getMessage());
    }

    @Test
    void testByName() {
        assertEquals(6, sc.getItem("First"));
    }

    @Test
    void testAddQuantityToSameItem() {
        assertEquals(6, sc.getItems().get(0).getQuantity());
    }
}
