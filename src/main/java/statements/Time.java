package statements;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
    }

    public int getInMinutes() {
        int minutesPerHour=60;
        return (hours*minutesPerHour)+minutes;
    }

    public int getInSeconds() {
        int secondsPerMinute=60;
        return (getInMinutes()*secondsPerMinute)+seconds;
    }

    public boolean earlierThan(Time otherTime) {
        return this.getInSeconds()<otherTime.getInSeconds();
    }

    public String toString() {
        return hours+":"+minutes+":"+seconds;
    }
}
