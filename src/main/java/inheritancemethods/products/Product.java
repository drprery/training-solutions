package inheritancemethods.products;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal unitWeigth;
    private int numberOfDecimals=2;

    public Product(){}

    public Product(String name, BigDecimal unitWeigth) {
        this.name = name;
        this.unitWeigth = unitWeigth;
    }

    public Product(String name, BigDecimal unitWeigth, int numberOfDecimals) {
        this.name = name;
        this.unitWeigth = unitWeigth;
        this.numberOfDecimals = numberOfDecimals;
    }

    public BigDecimal totalWeight(int pieces){
        return unitWeigth.multiply(BigDecimal.valueOf(pieces)).setScale(numberOfDecimals);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeigth;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }
}
