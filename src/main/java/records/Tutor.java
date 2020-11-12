package records;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    List<Subject> taughtSubjects=new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject){
        boolean found=false;
        for(Subject sub:taughtSubjects){
            if(sub.getSubjectname().equals(subject.getSubjectname())){
                found=true;
            }
        }
        return found;
    }

    public String getName() {
        return name;
    }
}
