package week10d02;

import java.util.List;

public class MaxTravel {
    private int[] stations;

    public int getMaxIndex(List<Integer> passengers) {
        if (passengers == null || passengers.isEmpty()) {
            throw new IllegalArgumentException();
        }

        stations=new int[30];
        getStations(passengers);

        return getMaxPassenger();
    }

    private int getMaxPassenger() {
        int passenger = 0;
        for (int i = 0; i < stations.length; i++) {
            if (stations[passenger] < stations[i]) {
                passenger = i;
            }
        }
        return passenger;
    }

    private void getStations(List<Integer> passengers) {
        for (int i : passengers) {
            if(i>29){
                throw new IllegalArgumentException();
            }
            stations[i]++;
        }
    }
}
