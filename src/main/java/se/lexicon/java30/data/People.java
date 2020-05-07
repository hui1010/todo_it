package se.lexicon.java30.data;

import se.lexicon.java30.model.Person;
import java.util.Arrays;
import static se.lexicon.java30.data.PersonSequencer.nextPersonId;


public class People {
    private static Person[] person = new Person[0];

    public People() {
    }

    public People(Person[] person) {
        this.person = person;
    }

    public static Person[] getPerson() {
        return person;
    }

    public static void setPerson(Person[] person) {
        People.person = person;
    }

    public int size(){
        return person.length;
    }

    public Person[] findAll(){
        return person;
    }

    public Person findById(final int personId){
        Person matchPerson = new Person();
        for(int i = 0; i < person.length; i++) {
            if(personId == person[i].getPersonId()){
                matchPerson = person[i];
                break;
            }
        }
        return matchPerson;
    }

    public boolean addPerson(final String firstName, final String lastName){
        //make sure not add an empty person, but the new person can have the same name as other people
        if (firstName == null && lastName == null){
            return false;
        }

        person = addNewPerson(person, firstName, lastName);
        return true;
    }

    private Person[] addNewPerson(final Person[] source, final String firstName, final String lastName){
        // create a new Person object for the person you want to add in
        Person addedPerson = new Person(nextPersonId(), firstName, lastName);
        // have to extend the size of
        Person[] addedPersonArray = Arrays.copyOf(source, source.length + 1);
        // add the new person at the end of the new array
        addedPersonArray[addedPersonArray.length - 1] = addedPerson;
        return addedPersonArray;
    }



    public boolean removePeople(final String firstName, final String lastName){
        int index = getIndex(person, firstName, lastName); // call a method to find who should be removed, get the index
        if (index < 0){
            return false; // means couldn't find the object
        }
        person = removeByIndex(person, index); //call the method to remove the object who has the index
        return true;
    }

    private Person[] removeByIndex(final Person[] person, final int index) {
        //copy the parts of array before and after the index respectively
        Person[] first = Arrays.copyOfRange(person, 0, index);
        Person[] last = Arrays.copyOfRange(person, index + 1, person.length);
        Person[] combined = Arrays.copyOf(first, first.length + last.length);
        for(int i= first.length, j = 0; j < last.length; i++, j++) {
            combined[i] = last[j]; // add in elements in last part of array one by one
        }
        return combined;
    }

    private int getIndex(Person[] person, String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < person.length; i++) {
            if (person[i].getFirstName() == firstName && person[i].getLastName() == lastName){ //first and last name match
                index = i;
                break;
            }
        }
        return index;
    }
    public void clear(){
        person = new Person[0];
    }
}
