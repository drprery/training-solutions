package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store(List<Product> products){
        this.products=new ArrayList<>(products);
    }

    public int getProductByCategoryName(Category category){
        int num=0;
        for(Product product:products){
            if(product.getCategory().equals(category)){
                num++;
            }
        }
        return num;
    }
}
