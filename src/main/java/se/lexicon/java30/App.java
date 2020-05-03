package se.lexicon.java30;

import se.lexicon.java30.data.People;
import se.lexicon.java30.data.TodoItems;
import se.lexicon.java30.model.Person;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        People people = new People();
        people.setPerson(people.addNewPerson("Anna","Bok"));
        people.setPerson(people.addNewPerson("Bo","Bosson"));
        /*System.out.println(people.size());
        System.out.println(people.findById(1).getFirstName());
        System.out.println(people.findById(2).getFirstName());
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.findAll()[i].getFirstName() + " " + people.findAll()[i].getLastName());
        }*/
        TodoItems dada = new TodoItems();
        dada.setTodo(dada.addNewTodo("go to sleep"));
        dada.setTodo(dada.addNewTodo("go to eat"));
        dada.setTodo(dada.addNewTodo("go to play"));
        dada.setTodo(dada.addNewTodo("go to eat"));
        dada.setTodo(dada.addNewTodo("go to play"));

        dada.findById(1).setAssignee(people.findById(1));
        dada.findById(2).setAssignee(people.findById(2));
        //dada.findById(3).setAssignee(people.findById(2));
        //dada.findById(1).setDone(true);

        //System.out.println(Arrays.toString(dada.findByDoneStatus(false)));
        /*System.out.println(dada.findById(1).getAssignee().getPersonId());
        System.out.println(dada.findById(2).getAssignee().getPersonId());
        System.out.println(dada.findById(3).getAssignee().getPersonId());
        System.out.println(dada.findByAssignee(2).length);*/

        System.out.println(Arrays.toString(dada.findByAssignee(people.findById(2))));
        System.out.println(Arrays.toString(dada.findUnassignedTodoItems()));

    }
}
