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

    public Person[] findAll(){ //what does this method do?
        return person;
    }

    public Person findById(int personId){
        Person matchPerson = new Person();
        for(int i = 0; i < person.length; i++) {
            if(personId == person[i].getPersonId()){
                matchPerson = person[i];
                break;
            }
        }
        return matchPerson;
    }

    public Person[] addNewPerson(String firstName, String lastName){
        Person addedPerson = new Person(nextPersonId(), firstName, lastName);
        Person[] addedPersonArray = Arrays.copyOf(person, person.length + 1);
        addedPersonArray[addedPersonArray.length - 1] = addedPerson;
        return addedPersonArray;
    }

    public void clear(){
        person = new Person[0];
    }
}
