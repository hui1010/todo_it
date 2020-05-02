package se.lexicon.java30.modelTest;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.model.Person;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    public static final String FIRST_NAME = "Teddy";
    public static final String LAST_NAME = "Bear";
    public static final int PERSON_ID = 123;
    private Person TestPerson;
    @Before
    public void setUp() throws Exception {
        Person person = new Person(PERSON_ID, FIRST_NAME, LAST_NAME);
    }

    @Test
    public void given_first_name_Teddy_return_first_name_Teddy(){
      assertEquals(FIRST_NAME, TestPerson.getFirstName());
    }

    @Test
    public void given_last_name_Bear_return_last_name_Bear() {

        assertEquals(LAST_NAME, TestPerson.getLastName());
    }

    @Test
    public void given_personId_123_return_personId_123456() {

        assertEquals(PERSON_ID, TestPerson.getPersonId());
    }
}
