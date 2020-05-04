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
        for(int i = 0; i < person.length; i++) { // go through all the elements in person
            if(personId == person[i].getPersonId()){ // find the one who has the matching ID
                matchPerson = person[i]; // give it to matchPerson
                break; // jump out from the loop
            }
        }
        return matchPerson;
    }

    public Person[] addNewPerson(final String firstName, final String lastName){
        Person addedPerson = new Person(nextPersonId(), firstName, lastName); // create a new Person object for the person you want to add in
        Person[] addedPersonArray = Arrays.copyOf(person, person.length + 1); // created a new longer array so the new object can be added
        addedPersonArray[addedPersonArray.length - 1] = addedPerson; // add the new person at the end of the new array
        return addedPersonArray;
    }

    public void clear(){
        person = new Person[0];
    } // don't loop and set null for every element

    public boolean removePeople(final String firstName, final String lastName){
        int index = getIndex(person, firstName, lastName); // call a method to find who should be removed, get the index
        if (index < 0){
            return false; // means couldn't find the object
        }
        person = removeByIndex(person, index); //call the method to remove the object who has the index
        return true;
    }

    private Person[] removeByIndex(final Person[] person, final int index) {
        Person[] first = Arrays.copyOfRange(person, 0, index); // copy the part of array that before the index
        Person[] last = Arrays.copyOfRange(person, index + 1, person.length);// copy the part of array that after the index
        Person[] combined = Arrays.copyOf(first, first.length + last.length); // copy the first array and its length should be two arrays together
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
}
