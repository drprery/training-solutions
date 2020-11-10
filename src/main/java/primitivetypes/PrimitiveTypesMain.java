package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        System.out.println(new PrimitiveTypes().toBinaryString(100));
        System.out.println(Integer.toBinaryString(100));

        System.out.println(new PrimitiveTypes().toBinaryString(1234));
        System.out.println(Integer.toBinaryString(1234));
    }
}
