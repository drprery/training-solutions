package week07d01;

public class MathAlgorithms {
    public static boolean isPrime(int x) {
        if(x<1){
            throw new IllegalArgumentException("A szám nem nagyobb nullánál!");
        }

        int m = 0;
        boolean flag = true;

        if (x == 1) {
            flag = false;
        } else {
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0) {
                    flag = false;
                    break;
                }
            }

        }
        return flag;
    }
}
