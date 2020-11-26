package week05d04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {
    @Test
    public void noneExpired(){
        Store store=new Store();
        store.addProduct(new Product("tej",2020,12,30));
        store.addProduct(new Product("vaj",2020,12,29));
        store.addProduct(new Product("sajt",2020,12,28));

        assertEquals(0,store.getNumberOfExpired());
    }

    @Test
    public void oneIsExpired() {
        Store store = new Store();
        store.addProduct(new Product("tej", 2020, 12, 30));
        store.addProduct(new Product("vaj", 2020, 12, 29));
        store.addProduct(new Product("sajt", 2020, 11, 25));

        assertEquals(1, store.getNumberOfExpired());
    }

    @Test
    public void allIsExpired(){
        Store store = new Store();
        store.addProduct(new Product("tej", 2020, 11, 3));
        store.addProduct(new Product("vaj", 2020, 11, 10));
        store.addProduct(new Product("sajt", 2020, 11, 25));

        assertEquals(3, store.getNumberOfExpired());
    }
}
