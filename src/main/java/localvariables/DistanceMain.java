package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance=new Distance(12.5,true);

        System.out.println("A távolság :"+distance.getDistanceInKm());
        System.out.println("Az érték "+(distance.isExact() ? "pontos":"pontatlan"));

        int distInt=(int)distance.getDistanceInKm();
        System.out.println("A távolság egészrésze: "+distInt);
    }
}
