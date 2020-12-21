package week08d05;

public class MathAlgorithms {

    public int greatestCommonDivisor(int first, int second) {
        if (first < 1 || second < 1) {
            throw new IllegalArgumentException("Nem lehet negatív szám, sem nulla.");
        }
        int divisor = 1;
        for (int i = 2; i <= first && i <= second; i++) {
            if (first % i == 0 && second % i == 0) {
                divisor = i;
            }
        }
        return divisor;
    }

}