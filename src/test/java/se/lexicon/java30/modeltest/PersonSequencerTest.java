package se.lexicon.java30.modeltest;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.java30.data.PersonSequencer;
import se.lexicon.java30.model.Person;

import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.PersonSequencer.getPersonId;
import static se.lexicon.java30.data.PersonSequencer.nextPersonId;

public class PersonSequencerTest {
    @Test
    public void test_if_PersonId_increase_every_time() {

        assertEquals(1, nextPersonId());
        assertEquals(2, nextPersonId());
        assertEquals(2, getPersonId());
    }

}
