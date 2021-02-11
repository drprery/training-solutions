package week15d04;

public class Data implements Comparable<Data> {

    private String yearAndWeek;
    private int cases;

    public Data(int cases, String yearAndWeek) {
        this.yearAndWeek = yearAndWeek;
        this.cases = cases;
    }

    public String getYearAndWeek() {
        return yearAndWeek;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public int compareTo(Data other) {
        return Integer.valueOf(this.cases).compareTo(other.cases);
    }
}