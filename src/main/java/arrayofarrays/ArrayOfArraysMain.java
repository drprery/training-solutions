package arrayofarrays;

import java.util.Arrays;

public class ArrayOfArraysMain {
    public static int[][] multiplicationTable(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void printArrayOfArrays(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j : a[i]) {
              if (j<10){
                  System.out.print("   "+j);
              } else if (j<100){
                  System.out.print("  "+j);
              } else if (j<1000){
                  System.out.print(" "+j);
              }
            }
            System.out.println();
        }
    }

    public static int[][] triangularMatrix(int size) {
        int[][] triMatrix = new int[size][];
        for (int i = 0; i < size; i++) {
            triMatrix[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triMatrix[i][j] = i;
            }
        }
        return triMatrix;
    }

    public static int[][] getValues() {
        int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] months = new int[12][];

        for (int i = 0; i < daysOfMonths.length; i++) {
            months[i] = new int[daysOfMonths[i]];
        }
        return months;
    }

    public static void main(String[] args) {
        int size = 6;
        int[][] table = multiplicationTable(size);

        System.out.println("*** multiplicationTable ***");

        printArrayOfArrays(table);

        System.out.println();

        System.out.println("*** printArrayOfArrays ***");

        int[][] arr1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printArrayOfArrays(arr1);

        System.out.println();

        System.out.println("*** triangularMatrix ***");
        printArrayOfArrays(triangularMatrix(5));

        System.out.println();

        System.out.println("*** getValues ***");
        System.out.println(Arrays.deepToString(getValues()));
    }
}
