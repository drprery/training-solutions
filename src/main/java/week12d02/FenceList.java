package week12d02;

public class FenceList {

    private final int numberOfSite;
    private final Fence fence;

    public FenceList(Fence fence, int numberOfSite) {
        this.fence = fence;
        this.numberOfSite = numberOfSite;
    }

    public Fence getFence() {
        return fence;
    }

    public int getNumberOfSite() {
        return numberOfSite;
    }

}
