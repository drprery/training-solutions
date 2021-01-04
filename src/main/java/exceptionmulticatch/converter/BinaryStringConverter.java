package exceptionmulticatch.converter;

public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null) {
            throw new NullPointerException("binaryString null");
        }

        boolean[] booleans = new boolean[str.length()];
        String ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.substring(i, i + 1);
            if (ch.equals("0") || ch.equals("1")) {
                if (ch.equals("0")) {
                    booleans[i] = false;
                } else {
                    booleans[i] = true;
                }
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return booleans;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        StringBuilder str = new StringBuilder();

        if (booleans.length == 0) {
            throw new IllegalArgumentException("booleans size 0");
        }
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                str.append("1");
            } else {
                str.append("0");
            }
        }
        return str.toString();
    }
}
