package virtualmethod.vehicle;

public class Car extends Vehicle{
    private int numberOfPassenger;

    public Car(int vehicleWeight, int numberOfPassenger) {
        super(vehicleWeight);
        this.numberOfPassenger = numberOfPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad()+numberOfPassenger*Car.PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfPassenger=" + numberOfPassenger +
                ", vehicleWeight="+super.getVehicleWeight()+"}";
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }
}
