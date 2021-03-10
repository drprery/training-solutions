package exam03retake02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public int getNumberOfItemsLeft(){
        int todoNum=0;
        for(Todo todo : todos){
            if(todo.getState()==State.NON_COMPLETED){
                todoNum++;
            }
        }
        return todoNum;
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<String> getMostImportantTodosText(){
        List<Todo> sortedTodosByPriority = new ArrayList<>(todos);
        List<String> mostImportantTodos = new ArrayList<>();

        sortedTodosByPriority.sort(new Comparator<Todo>() {
            @Override
            public int compare(Todo o1, Todo o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        mostImportantTodos.add(sortedTodosByPriority.get(0).getText());
        int i = 1;

        while(sortedTodosByPriority.get(i).getPriority() == sortedTodosByPriority.get(0).getPriority()){
            mostImportantTodos.add(sortedTodosByPriority.get(i).getText());
            i++;
        }

        return mostImportantTodos;
    }

    public void deleteCompleted(){
        List<Todo> newTodos = new ArrayList<>();

        for(Todo todo : todos){
            if(todo.getState()==State.NON_COMPLETED){
                newTodos.add(todo);
            }
        }

        todos = newTodos;
    }
}
