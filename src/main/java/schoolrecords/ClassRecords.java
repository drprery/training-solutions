package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        boolean found = false;
        for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                found = true;
            }
        }
        if (!found) {
            students.add(student);
        }
        return !found;
    }

    public boolean removeStudent(Student student) {
        boolean found = false;
        for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                found = true;
            }
        }
        if (found) {
            students.remove(student);
        }
        return found;
    }

    public double calculateClassAverage(){
        if(students.size()==0){
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double markValueSum = 0.0;
        for (Student student : students) {
            if(student.calculateAverage()==0.0){
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
            markValueSum += student.calculateAverage();
        }
        //return Math.round((markValueSum / students.size())*100)/100.0;
        return Double.parseDouble(String.format(Locale.US, "%.2f",markValueSum / students.size()));
    }

    public double calculateClassAverageBySubject(Subject subject){
        double markValueSum = 0.0;
        int markNum=0;
        for (Student student : students) {
            if(student.calculateSubjectAverage(subject)>0) {
                markValueSum += student.calculateSubjectAverage(subject);
                markNum++;
            }
        }
        return Double.parseDouble(String.format(Locale.US,"%.2f",markValueSum / markNum));
    }

    public Student findStudentByName(String name){
        if(isEmpty(name)){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if(students.size()==0){
            throw new IllegalStateException("No students to search!");
        }

        Student foundStudent=null;
        for(Student student:students){
            if(student.getName().equals(name)){
                foundStudent=student;
                break;
            }
        }
        if(foundStudent==null){
            throw new IllegalArgumentException("Student by this name cannot be found! "+name);
        } else {
            return foundStudent;
        }
    }

    public Student repetition(){
        if(students.size()==0){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));

    }

    public List<StudyResultByName> listStudyResults(){
        List<StudyResultByName> studyResultByName=new ArrayList<>();

        for(Student student:students){
            studyResultByName.add(new StudyResultByName(student.calculateAverage(),student.getName()));
        }
        return studyResultByName;
    }

    public String listStudentNames(){
        String studentNames="";
        for(Student student:students){
            studentNames+=student.getName()+", ";
        }
        return studentNames.substring(0,studentNames.length()-2);
    }

    private boolean isEmpty(String name){
        return "".equals(name) || name==null;
    }
}
