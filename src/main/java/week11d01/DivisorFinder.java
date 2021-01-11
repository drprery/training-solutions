package week11d01;

public class DivisorFinder {
    public int findDivisors(int n) {
        int nr = 0;
        String[] numbers = (Integer.toString(Math.abs(n))).split("");
        for (String digit : numbers) {
            int x = Integer.parseInt(digit);

            if ((x != 0) && ((n % x) == 0)) {
                nr++;
            }
        }
        return nr;
    }
}
