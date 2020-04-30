package se.lexicon.java30.data;

public class PersonSequencer {
    private static int personId;
    static int counter = 0;
    public static int nextPersonId(){
        return ++counter;
    }

    public static int getPersonId(){
        return counter;
    }

    public static void reset(){
        counter = 0;
    }
}
