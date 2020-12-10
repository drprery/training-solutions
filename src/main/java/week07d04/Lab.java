package week07d04;

import java.time.LocalDateTime;

public class Lab {
    private String title;
    private boolean completed;
    private LocalDateTime completedAt;

    public Lab(String title) {
        this.title = title;
        completed = false;
    }

    public Lab(String title, int year, int month, int day, int hour, int minute) {
        this.title = title;
        this.completedAt = LocalDateTime.of(year, month, day, hour, minute);
        completed = true;
    }

    public void complete() {
        completedAt = LocalDateTime.now();
        completed = true;
    }

    public void complete(int year, int month, int day, int hour, int minute) {
        completedAt = LocalDateTime.of(year, month, day, hour, minute);
        completed = true;
    }

    @Override
    public String toString() {
        if (completed) {
            return "A " + title + " feladat el lett végezve: " + completedAt;
        } else {
            return "A " + title + " feladat még nincs elvégezve!";
        }
    }
}
