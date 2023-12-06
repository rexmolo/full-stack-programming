package io.github.rexmolo;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.id = generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.checkArguments();
    }

    public int generateId(){
        return ++this.id;
    }

    public void checkArguments(){
        String[] fieldName = {"firstName", "lastName", "email"};
        String[] fieldValue = {this.firstName, this.lastName, this.email};
        utils.checkArguments(fieldName, fieldValue);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        utils.checkArguments("firstName", firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        utils.checkArguments("lastName", lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        utils.checkArguments("email", email);
        this.email = email;
    }

    public String getSummary() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
