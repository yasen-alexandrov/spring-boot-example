package com.bosch.springbootexample.service;

import com.bosch.springbootexample.model.Person;
import com.bosch.springbootexample.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll(){
       return this.personRepository.findAll();
    }

    public List<Person> addPerson(Person person) {
        /**
         * More business logic here 
         */
        this.personRepository.save(person);
        return this.personRepository.findAll();
    }

    public void deletePerson(Integer id) {
        this.personRepository.deleteById(id);
    }

    public Person updatePerson(Person person) {
        Person updatedPerson = null;

        Optional<Person> dbPerson = this.personRepository.findById(person.getId());
        if (dbPerson.isPresent()) {
            updatedPerson = this.personRepository.save(person);
        }
       return updatedPerson;     
    }
}
