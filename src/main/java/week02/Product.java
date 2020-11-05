package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p){
        return (p.getName().equals(getName()));
    }

    public static void main(String[] args) {
        Product product1=new Product("product1","100");
        Product product2=new Product("product1","101");
        Product product3=new Product("product2","102");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));
    }
}
