package se.lexicon.java30.modeltest;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.java30.data.TodoSequencer;

import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.TodoSequencer.getTodoId;
import static se.lexicon.java30.data.TodoSequencer.nextTodoId;

public class TodoSequencerTest {
    @Test

    public void test_if_todoId_increase_every_time() {
        assertEquals(0, getTodoId());
        assertEquals(1, nextTodoId());
        assertEquals(2, nextTodoId());
        assertEquals(2, getTodoId());
    }
}
