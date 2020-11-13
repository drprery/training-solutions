package records;

import java.util.ArrayList;
import java.util.List;

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
        return ((int) ((markValueSum / marks.size()) * 100)) / 100.0;
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
        //return markValueSum / markNum;
        return ((int) ((markValueSum / markNum) * 100)) / 100.0;
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
        MarkType markType = marks.get(0).getMarkType();
        return getName() + " marks: " + marks.get(0).getSubject().getSubjectName() + ": " + markType.getDescription() + "(" + markType.getValue() + ")";
    }
}
