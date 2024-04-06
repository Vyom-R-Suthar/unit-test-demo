// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo.service;

import com.person.persondemo.entities.Person;
import com.person.persondemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllPerson(){
        return repository.findAll();
    }

    public Person createUser(Person person){
        Person savedPerson = repository.save(person);
        return savedPerson;
    }

    public Optional<Person> getPersonById(int id){
        Optional<Person> byId = repository.findById(id);
        return byId;
    }

    public String deletePersonById(int id){
        repository.deleteById(id);
        return "Success";
    }

    public String deleteAll(){
        repository.deleteAll();
        return "Success";
    }

    public String addPerson(Person person){
        repository.save(person);
        return "Person Added";
    }
}
