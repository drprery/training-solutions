package week12d02;

public class Site {

    private final Fence fenceType;
    private final int sideOfStreet;
    private final int lengthOfSide;

    public Site(int sideOfStreet, int lengthOfSide, Fence fenceType) {
        this.sideOfStreet = sideOfStreet;
        this.lengthOfSide = lengthOfSide;
        this.fenceType = fenceType;
    }

    public int getSideOfStreet() {
        return sideOfStreet;
    }

    public int getLengthOfSide() {
        return lengthOfSide;
    }

    public Fence getFenceType() {
        return fenceType;
    }

}
