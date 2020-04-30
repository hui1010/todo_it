package se.lexicon.java30.modeltest;

import org.junit.Test;
import se.lexicon.java30.model.Person;
import se.lexicon.java30.model.Todo;
import static org.junit.Assert.assertEquals;

public class TodoTest {
    @Test
    public void given_todoId_123_return_123() {
        Todo todo = new Todo(123,null);
        int expectedTodoId = 123;
        assertEquals(expectedTodoId,todo.getTodoId());
    }

    @Test
    public void given_description_OhOhOh_return_OhOhOh() {
        Todo todo = new Todo();
        todo.setDescription("OhOhOh");
        String expectedDescription = "OhOhOh";
        assertEquals(expectedDescription,todo.getDescription());
    }

    @Test
    public void set_done_to_false_return_isDone_false() {
        Todo todo = new Todo();
        todo.setDone(false);
        boolean expectedIsDone = false;
        assertEquals(expectedIsDone,todo.isDone());
    }

    @Test
    public void given_assignee_123TeddyBear_return_123TeddyBear() {
        Todo todo = new Todo();
        Person person = new Person(123,"Teddy", "Bear");
        Person expectedPerson = new Person();
        expectedPerson.setFirstName("Teddy");
        expectedPerson.setLastName("Bear");
        assertEquals(expectedPerson.getFirstName(),person.getFirstName());
        assertEquals(expectedPerson.getLastName(), person.getLastName());
        expectedPerson = person;
        assertEquals(expectedPerson.getFirstName(),person.getPersonId());
    }
}
