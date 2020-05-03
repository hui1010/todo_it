package se.lexicon.java30.data;

import se.lexicon.java30.model.Person;
import se.lexicon.java30.model.Todo;

import java.util.Arrays;

import static se.lexicon.java30.data.TodoSequencer.nextTodoId;

public class TodoItems {
    private static Todo[] todo = new Todo[0];

    public TodoItems() {
    }

    public TodoItems(Todo[] todo){
        this.todo = todo; // setTodo(todo);
    }

    public static Todo[] getTodo() {
        return todo;
    }

    public static void setTodo(Todo[] todo) {
        TodoItems.todo = todo;
    }

    public int size(){
        return todo.length;
    }

    public Todo[] findAll(){ // what will this method be used for?
        return todo;
    }

    public Todo findById(int todoId){
        Todo matchTodo = new Todo();
        for (int i = 0; i < todo.length; i++) {
            if(todoId == todo[i].getTodoId()) {
                matchTodo = todo[i];
                break;
            }
        }
        return matchTodo;
    }

    public Todo[] addNewTodo(String description){
        Todo addedTodo = new Todo(nextTodoId(), description);
        Todo[] addedTodoArray = Arrays.copyOf(todo, todo.length + 1);
        addedTodoArray[addedTodoArray.length - 1] = addedTodo;
        return addedTodoArray;
    }

    public void clear(){
        todo = new Todo[0];
    }

    public Todo[] findByDoneStatus(boolean doneStatus){
        Todo[] matchStatus = new Todo[0];
        for (int i = 0; i < todo.length; i++) {
            if(doneStatus == todo[i].isDone()){
                matchStatus = Arrays.copyOf(matchStatus, matchStatus.length + 1);
                matchStatus[matchStatus.length - 1] = todo[i];
            }
        }
        return matchStatus;
    }

    public Todo[] findByAssignee(int personId){
        Todo[] matchAssignee = new Todo[0];
        for (int i = 0; i < todo.length; i++) {
            if (todo[i].getAssignee() != null){
                if (personId == todo[i].getAssignee().getPersonId()) {
                    matchAssignee = Arrays.copyOf(matchAssignee, matchAssignee.length + 1);
                    matchAssignee[matchAssignee.length - 1] = todo[i];
                }
            }
        }
        return matchAssignee;
    }

    public Todo[] findByAssignee(Person assignee){
        Todo[] matchAssignee = new Todo[0];
        for (int i = 0; i < todo.length ; i++) {
            if (todo[i].getAssignee() != null){
                if (assignee == todo[i].getAssignee()){
                    matchAssignee = Arrays.copyOf(matchAssignee, matchAssignee.length + 1);
                    matchAssignee[matchAssignee.length - 1] = todo[i];
                }
            }
        }
        return matchAssignee;
    }

    public Todo[] findUnassignedTodoItems(){
        Todo[] unassigned = new Todo[0];
        for (int i = 0; i < todo.length; i++) {
            if (todo[i].getAssignee() == null){
                unassigned = Arrays.copyOf(unassigned, unassigned.length + 1);
                unassigned[unassigned.length - 1] = todo[i];
            }
        }
        return unassigned;
    }

}
