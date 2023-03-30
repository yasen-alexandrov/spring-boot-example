package com.bosch.springbootexample.model;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

//     Mapping to the other table
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Person> people;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Person> getPeople() {
//        return people;
//    }
//
//    public void setPeople(List<Person> people) {
//        this.people = people;
//    }
}
