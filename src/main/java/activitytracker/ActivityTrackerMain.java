package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.Month;

public class ActivityTrackerMain {
    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Can not connect!");
        }

        try (Connection conn = dataSource.getConnection();

             PreparedStatement pstmt = conn.prepareStatement("insert into activitytracker values (?, ?, ?)")) {
            Activity activity1 = new Activity(1, LocalDateTime.of(2021, Month.JANUARY, 2, 8, 0), "Első", ActivityType.RUNNING);
            Activity activity2 = new Activity(2, LocalDateTime.of(2021, Month.FEBRUARY, 1, 8, 0), "Második", ActivityType.HIKING);
            Activity activity3 = new Activity(3, LocalDateTime.of(2021, Month.MARCH, 1, 8, 0), "Harmadik", ActivityType.BIKING);

            pstmt.setTimestamp(1, Timestamp.valueOf(activity1.getStartTime()));
            pstmt.setString(2, activity1.getDesc());
            pstmt.setString(3, activity1.getType().toString());
            pstmt.executeUpdate();

            pstmt.setTimestamp(1, Timestamp.valueOf(activity2.getStartTime()));
            pstmt.setString(2, activity3.getDesc());
            pstmt.setString(3, activity1.getType().toString());
            pstmt.executeUpdate();

            pstmt.setTimestamp(1, Timestamp.valueOf(activity3.getStartTime()));
            pstmt.setString(2, activity3.getDesc());
            pstmt.setString(3, activity1.getType().toString());
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert!");
        }
    }
}
