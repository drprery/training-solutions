package week07.d02;

public class DigitSum {
    public DigitSum() {
    }

    public int sumOfDigits(int x) {
        int sum = 0;
        String[] nums = Integer.toString(x).split("");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
