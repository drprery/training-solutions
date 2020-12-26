package week09d03;

public enum Present {
    TOY(1), ELECTRONIC(2), HOUSEKEEPING(3), DECORATION(4);

    private int value;

    private Present(int num){
        value=num;
    }

    public int getValue() {
        return value;
    }
}
