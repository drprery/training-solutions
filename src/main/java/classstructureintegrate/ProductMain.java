package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("A termék neve :");
        String name=scanner.nextLine();

        System.out.println("A termék ára :");
        int price=scanner.nextInt();

        Product product=new Product(name, price);

        System.out.println(product.getName()+": "+product.getPrice());

        product.increasePrice(5);
        System.out.println(product.getName()+": "+product.getPrice());

        product.decreasePrice(4);
        System.out.println(product.getName()+": "+product.getPrice());
    }
}
