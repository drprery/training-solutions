package week03d05;

public class Operation {
    private int leftOp;
    private int rightOp;

    public Operation(String operands) {
        int plusSign = operands.indexOf("+");
        if (plusSign > 0) {
            leftOp = Integer.parseInt(operands.substring(0, plusSign).trim());
            rightOp = Integer.parseInt(operands.substring(plusSign + 1).trim());
        } else {
            System.out.println("Nem adtál meg '+' karaktert!");
        }
    }

    public int getResult() {
        return leftOp + rightOp;
    }

}
