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
        ActivityType[] activityTypes = ActivityType.values();
        double[] dist=new double[activityTypes.length];

        for (Activity activity : activities) {
            dist[activity.getType().ordinal()] += activity.getDistance();
        }

        for(ActivityType activityType : activityTypes){
            report.add(new Report(activityType, dist[activityType.ordinal()]));
        }

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
