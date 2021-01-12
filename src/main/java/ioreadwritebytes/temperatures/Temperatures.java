package ioreadwritebytes.temperatures;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage(){
        double average=0.0;

        for(byte temp : data){
            average+=temp;
        }

        return average/365.0;
    }

    public double getMonthAverage(){
        double average=0.0;

        for(int i=335;i<365;i++){
            average+=data[i];
        }

        return average/30.0;
    }
}
