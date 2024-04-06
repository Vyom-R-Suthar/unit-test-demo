// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo.controller;

import com.person.persondemo.entities.Person;
import com.person.persondemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(service.getAllPerson());
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable("id") int id){
        Optional<Person> personById = service.getPersonById(id);
        return new ResponseEntity<>(personById, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<String> addPerson(@RequestBody Person person){
        return new ResponseEntity<>(service.addPerson(person),HttpStatus.OK);
    }
}
