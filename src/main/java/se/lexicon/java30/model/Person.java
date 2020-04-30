package se.lexicon.java30.model;

public class Person {
    private final int personId;
    private String firstName;
    private String lastName;

    public Person() {
        personId = getPersonId();
    }

    public Person(final int personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonId() {
        return personId;
    }



}
