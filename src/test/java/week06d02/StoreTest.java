package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void testProductNumbersCategoryNumbersAreZero(){
        List<Product> products=new ArrayList<>();

        products.add(new Product("Tej",Category.DAIRY,220));
        products.add(new Product("Vaj",Category.DAIRY,650));
        products.add(new Product("Kenyér",Category.BAKEDGOODS,250));

        Store store=new Store(products);

        assertEquals(0,store.getProductByCategoryName(Category.FROZEN));
    }

    @Test
    public void testProductNumbersWhenCategoryNumbersAreNotZero(){
        List<Product> products=new ArrayList<>();

        products.add(new Product("Tej",Category.DAIRY,220));
        products.add(new Product("Vaj",Category.DAIRY,650));
        products.add(new Product("Kenyér",Category.BAKEDGOODS,250));

        Store store=new Store(products);

        assertEquals(2,store.getProductByCategoryName(Category.DAIRY));
    }
}
