package io.github.rexmolo.models;

import io.github.rexmolo.utils.Verify;

import java.util.Objects;

public class Person {


    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private AppUser credentials;


    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.checkArguments();//try something
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.checkArguments();//try something
    }

    public Person() {
    }

//    public int generateId(){
//        return ++this.id;
//    }


    private void checkArguments(){
        String[] fieldName = {"firstName", "lastName", "email"};
        String[] fieldValue = {this.firstName, this.lastName, this.email};
        Verify.arguments(fieldName, fieldValue);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Verify.arguments("firstName", firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Verify.arguments("lastName", lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Verify.arguments("email", email);
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
