package se.lexicon.java30.dataTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.data.PersonSequencer;
import se.lexicon.java30.data.TodoItems;
import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.PersonSequencer.resetPersonId;
import static se.lexicon.java30.data.TodoSequencer.resetTodoId;

import se.lexicon.java30.data.People;
import se.lexicon.java30.data.TodoSequencer;

public class TodoItemsTest {
    TodoItems todoItemsTest = new TodoItems();
    People people = new People();

    @Before
    public void setUp() throws Exception {
    todoItemsTest.addTodoItem("read a book");
    todoItemsTest.addTodoItem("buy milk");
    todoItemsTest.addTodoItem("throw the garbage");
    people.addPerson("Anna", "Bok");
    people.addPerson("Bo", "Bosson");
    people.addPerson("Åke", "Tor");
    }

    @Test
    public void the_given_array_should_have_length_3() {
        assertEquals(3,todoItemsTest.size());
    }

    @Test
    public void test_find_all_method() {
        assertEquals(3, todoItemsTest.findAll().length); // Erik's suggestion
    }

    @Test
    //test if the element gets its ID according to the add sequence
    public void given_Id_number_2_return_buy_milk() {
        assertEquals("buy milk", todoItemsTest.findById(2).getDescription());
    }

    @Test
    public void length_becomes_4_when_a_new_todo_is_added() {
        todoItemsTest.addTodoItem("cook dinner");
        assertEquals(4, todoItemsTest.size());
    }

    @Test
    public void todo_array_becomes_empty_after_calling_clear_method() {
        todoItemsTest.clear();
        assertEquals(0, todoItemsTest.size());
    }

    @Test
    //test if the setDone method works, if the status is not set manually, it should have default value false
    public void search_true_return_2_elements() {
        todoItemsTest.findById(1).setDone(true);
        todoItemsTest.findById(2).setDone(true);
        assertEquals(2, todoItemsTest.findByDoneStatus(true).length);
    }

    @Test
    //if two TodoItems are correctly added to one person
    public void search_personId_2_find_2_objects() {
        todoItemsTest.findById(1).setAssignee(people.findById(1));
        todoItemsTest.findById(2).setAssignee(people.findById(2));
        todoItemsTest.findById(3).setAssignee(people.findById(2));
        assertEquals(2, todoItemsTest.findByAssignee(2).length);
    }

    @Test
    public void search_person_whose_id_is_2_find_2_objects() {
        todoItemsTest.findById(1).setAssignee(people.findById(1));
        todoItemsTest.findById(2).setAssignee(people.findById(2));
        todoItemsTest.findById(3).setAssignee(people.findById(2));
        assertEquals(2, todoItemsTest.findByAssignee(people.findById(2)).length);
    }

    @Test
    //set one assignee then the other two should remain unassigned
    public void unassignedTodoItems_should_return_2() {
        todoItemsTest.findById(3).setAssignee(people.findById(1));
        assertEquals(2, todoItemsTest.findUnassignedTodoItems().length);
    }

    @Test
    public void length_should_be_2_after_removing_one_todo_object() {
        todoItemsTest.removeTodoItem("buy milk");
        assertEquals(2, todoItemsTest.size());
        assertEquals("read a book", todoItemsTest.findById(1).getDescription());
        assertEquals("throw the garbage", todoItemsTest.findById(3).getDescription());
        assertEquals(null, todoItemsTest.findById(2).getDescription());
        // so it actually doesn't remove the Id number
    }

   @After
    public void tearDown() {
       todoItemsTest.clear();
       resetTodoId();
       resetPersonId();
    }
}
