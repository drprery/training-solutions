package week16d01;

import java.time.LocalDateTime;

public class CanoeRental {
    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
        this.endTime = null;
    }

    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }

    public double calculateRentalSum(){
        return canoeType.getValue()*5000;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
