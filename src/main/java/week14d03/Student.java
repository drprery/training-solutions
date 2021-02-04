package week14d03;

import java.util.*;

public class Student implements Comparable<Student>{
    private Map<String, List<Integer>> marks = new HashMap<>();
    private String name;

    public Student(String name){
        this.name = name;
    }

    public void setMark(String subject, int mark){
        List<Integer> marksTemp;

        if (marks.containsKey(subject)){
            marksTemp = marks.get(subject);
            marksTemp.add(mark);
            marks.put(subject, marksTemp);
        } else {
            marksTemp = new ArrayList<>(Arrays.asList(mark));
            marks.put(subject, marksTemp);
        }

    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student s){
        return this.name.compareTo(s.name);
    }
}
