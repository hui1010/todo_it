package se.lexicon.java30.modeltest;

import org.junit.Test;
import se.lexicon.java30.model.Todo;
import static org.junit.Assert.assertEquals;

public class TodoTest {
    @Test
    public void given_todoId_123_return_123() {
        Todo todo = new Todo(123,null);
        int expectedTodoId = 123;
        assertEquals(expectedTodoId,todo.getTodoId());
    }
}
