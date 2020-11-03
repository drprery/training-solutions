package introdate;

import java.time.LocalTime;
import java.time.LocalDate;

public class PerformanceTest {

    public static void main(String[] args) {
        Performance performance = new Performance("Queen", LocalDate.of(1980, 6,2), LocalTime.of(18, 0), LocalTime.of(20, 0));
        System.out.println(performance.getInfo());
    }
}