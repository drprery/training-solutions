package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger){
        if(boat.getMaxPassengers()>passengers.size()){
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("The boat is full!");
        }
    }

    public double getPriceForPassenger(Passenger passenger){

        return passenger.getCruiseClass().getValue()*basicPrice;
    }

    public Passenger findPassengerByName(String name){
        for(Passenger passenger : passengers){
            if(passenger.getName().equals(name)){
                return passenger;
            }
        }
        throw new IllegalArgumentException("The passenger is not found!");
    }

    public List<String> getPassengerNamesOrdered(){
        List<String> orderedNames = new ArrayList<>();

        for(Passenger passenger : passengers){
            orderedNames.add(passenger.getName());
        }

        Collections.sort(orderedNames);

        return orderedNames;
    }

    public double sumAllBookingsCharged(){
        double sum = 0.0;

        for(Passenger passenger : passengers){
            sum+=getPriceForPassenger(passenger);
        }

        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass(){
        Map<CruiseClass, Integer> summary = new HashMap<>();

        for(Passenger passenger : passengers){
            if(!summary.containsKey(passenger.getCruiseClass())){
                summary.put(passenger.getCruiseClass(), 0);
            }
            int number = summary.get(passenger.getCruiseClass());
            summary.put(passenger.getCruiseClass(), ++number);
        }

        return summary;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
