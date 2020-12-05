package week06d05;

public class Biscuit {
    private BiscuitType type;
    private int gramAmount;

    public Biscuit(){}

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType biscuitType, int gramAmount){
        return new Biscuit(biscuitType, gramAmount);
    }

    public BiscuitType getType() {
        return type;
    }

    public int getGramAmount() {
        return gramAmount;
    }
}
