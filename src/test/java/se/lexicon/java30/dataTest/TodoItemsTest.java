package se.lexicon.java30.dataTest;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.data.TodoItems;

import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.People.setPerson;
import static se.lexicon.java30.data.TodoItems.setTodo;
import se.lexicon.java30.data.People;

public class TodoItemsTest {
    TodoItems todoItemsTest = new TodoItems();
    People people = new People();

    @Before
    public void setUp() throws Exception {
    setTodo(todoItemsTest.addNewTodo("read a book"));
    setTodo(todoItemsTest.addNewTodo("buy milk"));
    setTodo(todoItemsTest.addNewTodo("throw the garbage"));
    setPerson(people.addNewPerson("Anna", "Bok"));
    setPerson(people.addNewPerson("Bo", "Bosson"));
    setPerson(people.addNewPerson("Åke", "Tor"));
    }

    @Test
    public void the_given_array_should_have_length_3() {
        assertEquals(3,todoItemsTest.size());
    }

    @Test
    public void test_find_all_method() {
        TodoItems expectedTodo = new TodoItems();
        setTodo(expectedTodo.addNewTodo("read a book"));
        setTodo(expectedTodo.addNewTodo("buy milk"));
        setTodo(expectedTodo.addNewTodo("throw the garbage"));
        assertEquals(expectedTodo.findAll(), todoItemsTest.findAll());
    }

    @Test
    public void given_Id_number_2_return_buy_milk() {
        assertEquals("buy milk", todoItemsTest.findById(2).getDescription());
    }

    @Test
    public void test_if_a_new_todo_is_added() {
        setTodo(todoItemsTest.addNewTodo("cook dinner"));
        assertEquals(4, todoItemsTest.size());
    }

    @Test
    public void todo_array_becomes_empty_after_calling_clear_method() {
        todoItemsTest.clear();
        assertEquals(0, todoItemsTest.size());
    }

    @Test
    public void search_true_return_2_elements() {
        todoItemsTest.findById(1).setDone(true);
        todoItemsTest.findById(2).setDone(true);
        assertEquals(2, todoItemsTest.findByDoneStatus(true).length);
    }

    @Test
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

    public void unassignedTodoItems_should_return_2() {
        todoItemsTest.findById(3).setAssignee(people.findById(1));
        assertEquals(2, todoItemsTest.findUnassignedTodoItems().length);
    }
}
