package week10d01;

import java.util.List;

public class Hiking {
    public double getPlusElevation(List<Gps> data) {
        double previous = data.get(0).getHeight();
        double actual = 0.0;
        double elevationSum = 0.0;

        for (int i = 1; i < data.size(); i++) {
            actual = data.get(i).getHeight();
            if (actual > previous) {
                elevationSum += (actual - previous);
            }
            previous = actual;
        }
        return elevationSum;
    }
}
