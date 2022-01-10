package com.xpanxion.java.assignments.model;

import java.util.Objects;

public class Person {

    //
    // Data members
    //

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String ssn;

    //
    // Constructors
    //

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
    }

    //
    // Accessors
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    //
    // Overrides
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() && getAge() == person.getAge() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName()) && getSsn().equals(person.getSsn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAge(), getSsn());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                '}' + '\n';
    }
}
