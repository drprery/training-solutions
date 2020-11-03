package introdate;

import java.time.LocalTime;
import java.time.LocalDate;

public class PerformanceTest {

    public static void main(String[] args) {
        Performance performance = new Performance("Queen", LocalDate.of(1980, 06,02), LocalTime.of(18, 00), LocalTime.of(20, 00));
        System.out.println(performance.getInfo());
    }
}