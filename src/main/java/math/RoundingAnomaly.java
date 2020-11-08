package math;

import java.util.Random;

public class RoundingAnomaly {
    private double rndNumbers[] = new double[1000];

    private double[] randomNumbers(int size, double max, int scale) {
        Random rnd = new Random();
        double[] numbers = new double[size];
        double factor = Math.pow(10, scale);

        for (int i = 0; i < size; i++) {
            numbers[i] = Math.round(rnd.nextDouble() * max * factor) / factor;
        }
        return numbers;
    }

    private double roundAfterSum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum = sum + number;
        }
        return Math.round(sum);
    }

    private double sumAfterRound(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum = sum + Math.round(number);
        }
        return sum;
    }

    public double difference(int size, double max, int scale) {
        rndNumbers = randomNumbers(size, max, scale);
        double afterSum = roundAfterSum(rndNumbers);
        double afterRound = sumAfterRound(rndNumbers);

        return Math.abs(afterSum - afterRound);
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();

        double sum = 0;
        for (int i = 0; i < 100; i++) {
            double diff = roundingAnomaly.difference(1000, 1000000, 5);
            sum = sum + diff;
            System.out.println("Difference : " + diff);
        }
        System.out.println(sum / 100);
    }
}
