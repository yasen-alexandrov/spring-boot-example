package com.bosch.springbootexample.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable=false)
    private Department department;

    public Person() {
    }

    public Person(String firstName, String lastName, Integer age, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
