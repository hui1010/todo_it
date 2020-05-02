package se.lexicon.java30;

import se.lexicon.java30.data.People;
import se.lexicon.java30.model.Person;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        People people = new People();
        people.setPerson(people.addNewPerson("Anna","Bok"));
        people.setPerson(people.addNewPerson("Bo","Bosson"));
        System.out.println(people.size());
        System.out.println(people.findById(1).getFirstName());
        System.out.println(people.findById(2).getFirstName());
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.findAll()[i].getFirstName() + " " + people.findAll()[i].getLastName());
        }


    }
}
