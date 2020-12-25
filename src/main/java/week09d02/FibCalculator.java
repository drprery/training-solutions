package week09d02;

public class FibCalculator {
    public static long sumEvens(int bound){
        int fibSum=4;
        int fibNum=2;
        int prevNum=1;
        int temp=0;

        while (fibNum<=bound){
            temp=fibNum;
            fibNum+=prevNum;
            prevNum=temp;
            fibSum+=fibNum;
        }

        return fibSum-fibNum;
    }
}
