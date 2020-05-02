package se.lexicon.java30.data;

public class PersonSequencer {
    static int counter = 0;

    public static int nextPersonId(){
        return ++counter;
    }

    public static int getPersonId(){
        return counter;
    }

    public static void resetPersonId(){
        counter = 0;
    }
}
