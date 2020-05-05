package se.lexicon.java30.modelTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.model.Person;
import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.PersonSequencer.nextPersonId;
import static se.lexicon.java30.data.PersonSequencer.resetPersonId;

public class PersonTest {
    public static final String FIRST_NAME = "Teddy";
    public static final String LAST_NAME = "Bear";
    private Person testPerson;
    @Before
    public void setUp() throws Exception {
        testPerson = new Person(nextPersonId(), FIRST_NAME, LAST_NAME);
    }

    @Test
    public void given_first_name_Teddy_return_first_name_Teddy(){
      assertEquals(FIRST_NAME, testPerson.getFirstName());
    }

    @Test
    public void given_last_name_Bear_return_last_name_Bear() {

        assertEquals(LAST_NAME, testPerson.getLastName());
    }

    @After
    public void tearDown() throws Exception {
        resetPersonId();
    }
}
