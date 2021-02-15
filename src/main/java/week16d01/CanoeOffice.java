package week16d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {
    private List<CanoeRental> rentals = new ArrayList<>();

    public void addRental(CanoeRental canoeRental){
        rentals.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name){
        for(CanoeRental canoeRental : rentals){
            if(canoeRental.getEndTime()==null && canoeRental.getName().equals(name)){
                return canoeRental;
            }
        }
        return null;
    }

    public void closeRentalByName(String name, LocalDateTime endTime){
        for(CanoeRental canoeRental : rentals){
            if(canoeRental.getName().equals(name)){
               canoeRental.setEndTime(endTime);
            }
        }
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        for (CanoeRental canoeRental : rentals) {
            if (canoeRental.getEndTime() == null) {
                if (canoeRental.getName().equals(name)) {
                    return Duration.between(canoeRental.getStartTime(), endTime).toHours()*canoeRental.calculateRentalSum();
                }
            }
        }
        return 0.0;
    }

    public List<CanoeRental> listClosedRentals(){
        List<CanoeRental> closeRentals = new ArrayList<>();

        for(CanoeRental canoeRental : rentals){
            if(canoeRental.getEndTime()!=null){
                closeRentals.add(canoeRental);
            }
        }

        Collections.sort(closeRentals, new Comparator<CanoeRental>() {
            @Override
            public int compare(CanoeRental o1, CanoeRental o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });

        return new ArrayList<>(closeRentals);
    }

    public Map<CanoeType, Integer> countRentals(){
        Map<CanoeType, Integer> countRent = new HashMap<>();

        for(CanoeRental canoeRental : rentals){
            if(!countRent.containsKey(canoeRental.getCanoeType())){
                countRent.put(canoeRental.getCanoeType(), 0);
            }
            int count = countRent.get(canoeRental.getCanoeType());
            countRent.put(canoeRental.getCanoeType(), ++count);
        }
        return countRent;
    }
}
