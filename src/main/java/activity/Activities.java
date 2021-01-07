package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> report = new ArrayList<>();

        for (Activity activity : activities) {
            report.add(new Report(activity.getType(), activity.getDistance()));
        }

        return report;
    }

    public int numberOfTrackActivities() {
        int sumOfTrackActivies = 0;

        for (Activity activity : activities) {
            if (activity.getType() != ActivityType.BASKETBALL) {
                sumOfTrackActivies++;
            }
        }

        return sumOfTrackActivies;
    }

    public int numberOfWithoutTrackActivities() {
        int sumOfWithoutTrackActivies = 0;

        for (Activity activity : activities) {
            if (activity.getType() == ActivityType.BASKETBALL) {
                sumOfWithoutTrackActivies++;
            }
        }

        return sumOfWithoutTrackActivies;
    }
}
