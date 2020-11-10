package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();

        System.out.println(operators.isEven(11));
        System.out.println(operators.isEven(22));

        System.out.println(16 >> 1); // osztás kettővel
        System.out.println(16 << 1); // szorzás kettővel
        System.out.println(13 >> 1);
        System.out.println(13 << 1);

        System.out.println(operators.multiplyByPowerOfTwo(3, 5)); // szorzás öttel
    }
}
