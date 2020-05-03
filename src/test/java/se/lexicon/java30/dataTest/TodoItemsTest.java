package se.lexicon.java30.dataTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.java30.data.People;
import se.lexicon.java30.data.TodoItems;
import se.lexicon.java30.model.Todo;

import static org.junit.Assert.assertEquals;
import static se.lexicon.java30.data.People.setPerson;
import static se.lexicon.java30.data.TodoItems.setTodo;
import static se.lexicon.java30.data.TodoSequencer.nextTodoId;

public class TodoItemsTest {
    TodoItems todoItemsTest = new TodoItems();

    @Before
    public void setUp() throws Exception {
    setTodo(todoItemsTest.addNewTodo("read a book"));
    setTodo(todoItemsTest.addNewTodo("buy milk"));
    setTodo(todoItemsTest.addNewTodo("throw the garbage"));
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
        assertEquals("buy milk", todoItemsTest.FindById(2).getDescription());
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
}
