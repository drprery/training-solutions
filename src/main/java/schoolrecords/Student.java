package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateAverage() {
        double markValueSum = 0.0;
        for (Mark mark : marks) {
            markValueSum += mark.getMarkType().getValue();
        }
        if (marks.size() > 0) {
            return Double.parseDouble(String.format(Locale.US, "%.2f", markValueSum / marks.size()));
        } else {
            return 0.0;
        }
    }

    public double calculateSubjectAverage(Subject subject) {
        double markValueSum = 0.0;
        int markNum = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                markValueSum += mark.getMarkType().getValue();
                markNum++;
            }
        }
        if (marks.size() > 0 && markNum > 0) {
            return Double.parseDouble(String.format(Locale.US, "%.2f", markValueSum / markNum));
        } else {
            return 0.0;
        }
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String str) {
        return str.equals("");
    }

    @Override
    public String toString() {
        String repr = getName();

        for (Mark mark : marks) {
            repr+=" marks: " + mark.getSubject().getSubjectName() + ": " + mark.getMarkType().getDescription() + "(" + mark.getMarkType().getValue() + ")\n"+" ".repeat(getName().length());
        }
        repr=repr.substring(0,repr.length()-(1+ getName().length()));

        return repr;
    }
}
