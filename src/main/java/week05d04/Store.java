package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products=new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public int getNumberOfExpired(){
        int count=0;

        for(Product product: products){
            if(product.getExpiry().isBefore(LocalDate.now())){
                count++;
            }
        }
        return count;
    }
}
