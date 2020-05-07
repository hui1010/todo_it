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

    public Todo[] findAll(){
        return todo;
    }

    public Todo findById(final int todoId){
        Todo matchTodo = new Todo(); // create a new object that will contain the matching result
        for (int i = 0; i < todo.length; i++) { //go through all the elements
            if(todoId == todo[i].getTodoId()) { //find the one that has the same ID
                matchTodo = todo[i];// put it inside the newly created object
                break;
            }
        }
        return matchTodo;
    }

    public boolean addTodoItem(final String description){
        //empty pointer exception check
        if (description == null){
            return false;
        }

        todo = addNewTodo(todo, description);
        return true;
    }

    private Todo[] addNewTodo(Todo[] source, final String description){
        Todo addedTodo = new Todo(nextTodoId(), description);//create a new object that will be added in
        Todo[] addedTodoArray = Arrays.copyOf(source, source.length + 1);//create a new array that is one size bigger
        addedTodoArray[addedTodoArray.length - 1] = addedTodo;//put the to be added object at the end of array
        return addedTodoArray;//bingo
    }


    public Todo[] findByDoneStatus(final boolean doneStatus){
        Todo[] matchStatus = new Todo[0];//create a new array to contain the matching objects, initialize 0
        for (int i = 0; i < todo.length; i++) {//go through all the elements
            if(doneStatus == todo[i].isDone()){//find who has the matching status
                matchStatus = Arrays.copyOf(matchStatus, matchStatus.length + 1);//extend the newly made array
                matchStatus[matchStatus.length - 1] = todo[i];//put the matching objects inside the array
            }
        }
        return matchStatus;
    }

    public Todo[] findByAssignee(final int personId){
        Todo[] matchAssignee = new Todo[0];
        for (int i = 0; i < todo.length; i++) {
            if (todo[i].getAssignee() != null){ // have to, must, make sure to check if it is null!!!!!
                if (personId == todo[i].getAssignee().getPersonId()) {
                    matchAssignee = Arrays.copyOf(matchAssignee, matchAssignee.length + 1);
                    matchAssignee[matchAssignee.length - 1] = todo[i];
                }
            }
        }
        return matchAssignee;
    }

    public Todo[] findByAssignee(final Person assignee){ //overload
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

    public boolean removeTodoItem(final String description) {
        int index = getIndex(todo, description);
        if (index < 0) {
            return false;
        }
        todo = removeByIndex(todo, index);
        return true;
    }

    private Todo[] removeByIndex(final Todo[] original, final int index){
        Todo[] first = Arrays.copyOfRange(original, 0, index);
        Todo[] last = Arrays.copyOfRange(original, index + 1, original.length);
        Todo[] combined = Arrays.copyOf(first, first.length + last.length);
        for(int i = first.length, j = 0; j < last.length; i++, j++) {
            combined[i] = last[j];
        }
        return combined;
    }

    private int getIndex(Todo[] original, String description) {
        int index = -1;
        for (int i = 0; i < original.length; i++){
            if (description == original[i].getDescription()){
                index = i;
                break;
            }
        }
        return index;
    }

    public void clear(){
        todo = new Todo[0];
    }
}
