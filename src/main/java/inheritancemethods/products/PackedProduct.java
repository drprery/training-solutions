package inheritancemethods.products;

import java.math.BigDecimal;

public class PackedProduct extends Product{
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeigth, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeigth, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces){
        int numberOfBoxes=(int)Math.ceil((double)pieces/packingUnit);

        return super.totalWeight(pieces).add(weightOfBox.multiply(new BigDecimal(Integer.toString(numberOfBoxes)))).setScale(super.getNumberOfDecimals());
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }
}
