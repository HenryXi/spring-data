package com.henryxi.springdata.keyvalue;

@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String firstName, lastName, description;

    private Employee() {}

    public Employee(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
}
