package se.lexicon.java30.dataTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.data.People;
import se.lexicon.java30.data.PersonSequencer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PeopleTest {
    People testPeopleObject = new People();

    @Before
    public void setUp() throws Exception {
        testPeopleObject.addPerson("Anna", "Bok");
        testPeopleObject.addPerson("Bo", "Bosson");
        testPeopleObject.addPerson("Åke", "Tor");
    }

    @Test
    public void testPeopleObject_successfully_created_with_3_people_added() {
        assertEquals("Anna", testPeopleObject.findById(1).getFirstName());
        assertEquals("Bok", testPeopleObject.findById(1).getLastName());
        assertEquals("Bo", testPeopleObject.findById(2).getFirstName());
        assertEquals("Bosson", testPeopleObject.findById(2).getLastName());
        assertEquals("Åke", testPeopleObject.findById(3).getFirstName());
        assertEquals("Tor", testPeopleObject.findById(3).getLastName());
    }


    @Test
    public void the_given_array_has_length_3() { // also means the add method works
        assertEquals(3,testPeopleObject.size());
    }

    @Test
    public void test_findAll_method() {

        assertEquals(3,testPeopleObject.findAll().length); // Erik's suggestion
    }

    @Test
    public void given_Id_number_3_return_Åke_Tor() {
        assertEquals("Åke", testPeopleObject.findById(3).getFirstName());
        assertEquals("Tor", testPeopleObject.findById(3).getLastName());
    }

    @Test
    public void return_true_if_a_new_person_is_added() {
        boolean isAdded = false;
        testPeopleObject.addPerson("Jonas", "Larsson");
        if(testPeopleObject.size() == 4){
            isAdded = true;
        }
        assertTrue("it is true", isAdded);
    }

   @Test
    public void Person_array_become_empty_after_calling_clear_method() {
        testPeopleObject.clear();
        assertEquals(0,testPeopleObject.size());
    }

    @Test
    public void Person_arrays_length_should_become_2_after_removing_one_person() {
        testPeopleObject.removePeople("Bo", "Bosson");
        assertEquals(2, testPeopleObject.findAll().length);
        assertEquals("Anna", testPeopleObject.findById(1).getFirstName());
        assertEquals("Tor", testPeopleObject.findById(3).getLastName());
        assertEquals(null, testPeopleObject.findById(2).getFirstName());
    }


    @After
    public void tearDown() {
        testPeopleObject.clear();
        PersonSequencer.resetPersonId();
    }
}
