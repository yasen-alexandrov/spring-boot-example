package com.bosch.springbootexample.repository;

import com.bosch.springbootexample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
