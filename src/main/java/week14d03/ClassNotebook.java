package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNotebook {
    private List<Student> notebook = new ArrayList<>();

    public ClassNotebook(List<Student> notebook){
        this.notebook = notebook;
    }
    public List<Student> getNotebook() {
        return notebook;
    }

    public List<Student> sortNotebook(){
        Collections.sort(notebook);
        return new ArrayList<>(notebook);
    }
}
