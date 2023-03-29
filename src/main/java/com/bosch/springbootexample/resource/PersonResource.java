package com.bosch.springbootexample.resource;

import com.bosch.springbootexample.model.Person;
import com.bosch.springbootexample.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/rest/person")
public class PersonResource {

    private PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/all")
    public List<Person> getAllPeople(){
        return this.personService.getAll();
    }

    @PostMapping(value = "/add")
    public List<Person> addPerson(@RequestBody Person person){
        this.personService.addPerson(person);
        return personService.getAll();
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        this.personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Person updatedPerson = this.personService.updatePerson(person);
        if (Objects.nonNull(updatedPerson)) {
            return ResponseEntity.ok().body(updatedPerson);
        } else {
            return ResponseEntity.badRequest().build();
        } 
    }
}
