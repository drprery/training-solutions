package exam02;

public class ArraySelector {
    ArraySelector() {
    }

    public String selectEvens(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        if (numbers.length == 0) {
            return "";
        }
        sb.append("[");

        for (int i = 0; i < numbers.length; i += 2) {
            sb.append(numbers[i]);
            sb.append(", ");
        }

        return sb.substring(0, sb.length() - 2).concat("]");
    }
}