package week13d02;

import java.time.LocalTime;

public class Fly {
    private String name;
    private String type;
    private String target;
    private LocalTime time;

    public Fly(String name, String type, String target, LocalTime time) {
        this.name = name;
        this.type = type;
        this.target = target;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }

    public LocalTime getTime() {
        return time;
    }

}
