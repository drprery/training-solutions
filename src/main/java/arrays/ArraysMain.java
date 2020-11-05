package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {
    public String numberOfDaysAsString() {
        int[] numOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numOfDays);
    }

    public List<String> daysOfWeek() {
        return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
    }

    public String multiplicationTableAsString(int size) {
        int[][] mulTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mulTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(mulTable);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] winnerNumber, int[] stakeNumber) {
        Arrays.sort(winnerNumber);
        Arrays.sort(stakeNumber);

        return Arrays.equals(winnerNumber, stakeNumber);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println("*** numberOfDaysAsString ***");
        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println();

        System.out.println("*** daysOfWeek ***");
        System.out.println(arraysMain.daysOfWeek());
        System.out.println();

        System.out.println("*** multiplicationTableAsString, size 5 ***");
        System.out.println(arraysMain.multiplicationTableAsString(5));
        System.out.println();

        System.out.println("*** sameTempValues ***");
        System.out.println(arraysMain.sameTempValues(new double[]{10, 12, 18}, new double[]{10, 12, 18}));
        System.out.println(arraysMain.sameTempValues(new double[]{10, 12, 18}, new double[]{15, 17, 22}));
        System.out.println();

        System.out.println("*** wonLottery ***");
        int[] winner = new int[]{11, 35, 19, 56, 47};
        int[] stake = new int[]{11, 56, 57, 47, 89};
        System.out.println(arraysMain.wonLottery(winner, stake));
        System.out.println();

        System.out.println("*** The original variables ***");
        System.out.println(Arrays.toString(stake));
        System.out.println(Arrays.toString(winner));
    }
}
