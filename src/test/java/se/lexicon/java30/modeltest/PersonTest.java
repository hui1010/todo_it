package se.lexicon.java30.modeltest;

import org.junit.Test;
import se.lexicon.java30.model.Person;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void given_first_name_Teddy_return_first_name_Teddy(){
      Person person = new Person();
      person.setFirstName("Teddy");
      String expectedFirstName = "Teddy";
      assertEquals(expectedFirstName, person.getFirstName());
    }

    @Test
    public void given_last_name_Bear_return_last_name_Bear() {
        Person person = new Person();
        person.setLastName("Bear");
        String expectedLastName = "Bear";
        assertEquals(expectedLastName, person.getLastName());
    }

    @Test
    public void given_personId_123456_return_personId_123456() {
        Person person = new Person(123456,"Teddy","Bear");
        int expectedId = 123456;
        assertEquals(expectedId, person.getPersonId());
    }
}
