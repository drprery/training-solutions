package primitivetypes;

public class PrimitiveTypes {

    public static final int BITS = 32;

    public String toBinaryString(int n) {
        String s = "";
        for (int number = n; number > 0; ) {
            int bit = number % 2;
            s = bit + "" + s;
            number = number / 2;
        }
        int zeros = BITS - s.length();
        for (int i = 0; i < zeros; i++) {
            s = "0" + s;
        }
        return s;
    }
}
