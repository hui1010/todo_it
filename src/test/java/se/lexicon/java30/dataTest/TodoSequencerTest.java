package se.lexicon.java30.dataTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.PersonSequencer.*;
import static se.lexicon.java30.data.TodoSequencer.*;

public class TodoSequencerTest {
    @Test

    public void test_all_the_method_work_correctly() {
        assertEquals(0, getTodoId()); // test if it starts from 0
        assertEquals(1, nextTodoId()); // test if it increase to 1 when create a new object
        assertEquals(2, nextTodoId()); // test if it increase to 2 when create the second object
        assertEquals(2, getTodoId()); // test if the current ID increase
        resetTodoId();
        assertEquals(0, getTodoId()); // test if the TodoId is reset to 0
        assertEquals(1, nextTodoId()); // test if the TodoSequencer works fine after reset
        assertEquals(1, getTodoId());

        resetTodoId(); // test if the program crashes when double reset
        resetTodoId();
        assertEquals(1, nextTodoId());
    }
}
