package se.lexicon.java30.data;

public class TodoSequencer {
    static int counter = 0;
    public static int nextTodoId(){
        return ++counter;
    }

    public static int getTodoId(){
        return counter;
    }

    public static void reset(){
        counter = 0;
    }
}
