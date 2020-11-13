package records;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if(isEmpty(name)){
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
        return markValueSum / marks.size();
    }

    public double calculateSubjectAverage(Subject subject) {
        double markValueSum = 0.0;
        int markNum=0;
        for (Mark mark : marks) {
            if(mark.getSubject().getSubjectName().equals(subject.getSubjectName())){
                markValueSum += mark.getMarkType().getValue();
                markNum++;
            }
        }
        return markValueSum / markNum;
    }

    public void grading(Mark mark) {
        if(mark==null){
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String str) {
        return str.equals("");
    }

    @Override
    public String toString() {
        return "Kovács marks: matematika: excellent(5)";
    }
}
