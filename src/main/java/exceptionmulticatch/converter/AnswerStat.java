package exceptionmulticatch.converter;

public class AnswerStat {
    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String str) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException(e);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] booleans = convert(answers);
        int one = 0;

        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i] == true) {
                one++;
            }
        }

        return (int) (one / (booleans.length / 100.0));
    }
}
