package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem){
        this.employee = timeSheetItem.getEmployee();
        this.project = timeSheetItem.getProject();
        this.from = timeSheetItem.getFrom();
        this.to = timeSheetItem.getTo();
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate){
        TimeSheetItem localTimeSheetItem = new TimeSheetItem(timeSheetItem);

        int hour = localTimeSheetItem.getFrom().getHour();
        int minute = localTimeSheetItem.getFrom().getMinute();

        LocalDateTime localDateTime1 = localDate.atTime(hour, minute);
        localTimeSheetItem.setFrom(localDateTime1);

        hour = localTimeSheetItem.getTo().getHour();
        minute = localTimeSheetItem.getTo().getMinute();
        localDateTime1 = localDate.atTime(hour, minute);
        localTimeSheetItem.setTo(localDateTime1);

        return localTimeSheetItem;
    }
}
