package se.lexicon.java30.dataTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.PersonSequencer.*;

public class PersonSequencerTest {
    @Test
    public void test_if_PersonId_increase_every_time() {

        assertEquals(1, nextPersonId()); // test if personId is added to 1 after creating a new Person object
        assertEquals(2, nextPersonId()); // test if personId is added to 2 after creating the second object
        assertEquals(2, getPersonId());
        resetPersonId();
        assertEquals(0, getPersonId()); // test if PersonId is reset to 0 by the reset PersonId method
        assertEquals(1, nextPersonId()); // test if nextPersonId works fine after reset

        resetPersonId(); // test if the program crashes when double reset
        resetPersonId();
        assertEquals(1, nextPersonId());
    }

}
