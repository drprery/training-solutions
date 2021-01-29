package collectionslist.collectionsarraylist;

import java.util.*;

public class Lottery {
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount){

        if(lotteryType>=ballCount){throw new IllegalArgumentException("Balls must be more then the winning numbers!");}

        Set<Integer> balls = new HashSet<>();

        while (balls.size()<lotteryType){
            balls.add(new Random().nextInt(ballCount)+1);
        }

        return new ArrayList<>(balls);
    }
}
