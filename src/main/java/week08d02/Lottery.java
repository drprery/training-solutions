package week08d02;

import java.util.*;

public class Lottery {


    public Set<Integer> getNumbers(){
        Set<Integer> lotteryNums=new TreeSet<>();
        Random random=new Random();

        while(lotteryNums.size()<5){
            random.setSeed(System.currentTimeMillis());
            lotteryNums.add(random.nextInt(90)+1);
        }
        return lotteryNums;
    }

    public static void main(String[] args) {

        Lottery lottery=new Lottery();

        for(int i=1;i<10;i++){
            System.out.println(lottery.getNumbers());
        }
    }
}
