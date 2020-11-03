package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        for (int i:source) {
            if (i==itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind) {
        for (int i=0;i<source.length;i++) {
            if (source[i]==itemToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler=new ArrayHandler();

        int[] array=new int[]{1,2,3,5,8,13,21};

        System.out.println("*** Testing the contains method ***");
        System.out.println(arrayHandler.contains(array, 13));
        System.out.println(arrayHandler.contains(array, 4));

        System.out.println();

        System.out.println("*** Testing the find method ***");
        System.out.println(arrayHandler.find(array, 1));
        System.out.println(arrayHandler.find(array, 4));
    }
}
