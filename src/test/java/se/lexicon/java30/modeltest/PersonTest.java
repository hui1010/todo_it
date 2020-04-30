package se.lexicon.java30.modeltest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.model.Person;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void given_first_name_Teddy_return_first_name_Teddy(){
      Person person = new Person();
      person.setFirstName("Teddy");
      String expectedResult = "Teddy";
      String actualResult = person.getFirstName();
      assertEquals(expectedResult,actualResult);
    }

    @Test
    public void given_last_name_Bear_return_last_name_Bear() {
        Person person = new Person();
        person.setLastName("Bear");
        String expectedResult = "Bear";
        String actualResult = person.getLastName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void given_personId_123456_return_personId_123456() {
        Person person = new Person(123456,"Teddy","Bear");
        int expectedId = 123456;
        int actualId = person.getPersonId();
        assertEquals(expectedId,actualId);
    }
}
