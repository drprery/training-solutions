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
        double[] dist=new double[4];

        for (Activity activity : activities) {
            dist[activity.getType().ordinal()] += activity.getDistance();
        }

        report.add(new Report(ActivityType.BIKING, dist[0]));
        report.add(new Report(ActivityType.HIKING, dist[1]));
        report.add(new Report(ActivityType.RUNNING, dist[2]));
        report.add(new Report(ActivityType.BASKETBALL, dist[3]));

        return report;
    }

    public int numberOfTrackActivities() {
        int sumOfTrackActivities = 0;

        for (Activity activity : activities) {
            if (activity.getType() != ActivityType.BASKETBALL) {
                sumOfTrackActivities++;
            }
        }

        return sumOfTrackActivities;
    }

    public int numberOfWithoutTrackActivities() {
        int sumOfWithoutTrackActivities = 0;

        for (Activity activity : activities) {
            if (activity.getType() == ActivityType.BASKETBALL) {
                sumOfWithoutTrackActivities++;
            }
        }

        return sumOfWithoutTrackActivities;
    }
}
