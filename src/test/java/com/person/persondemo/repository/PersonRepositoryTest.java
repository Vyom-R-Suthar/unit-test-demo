package com.person.persondemo.repository;

import com.person.persondemo.entities.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    private Person person;

    @BeforeEach
    void setUp() {
        System.out.println("Inside setup method");
        person = new Person(123,"Vyom","Gandhinagar");
        repository.save(person);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside tear down method");
        person = null;
        repository.deleteAll();
    }

    @Test
    void testIsPersonExistbyId(){
        boolean existById = repository.isPersonExistById(123);
        assertThat(existById).isTrue();
    }


    @Test
    void testFindByPersonName() {
        Person person = repository.findByPersonName("Vyom");
        assertThat(person.getPersonName()).isEqualTo("Vyom");
    }


    @Test
    void testGetTotalPerson() {
        int actualCount = repository.getTotalPerson();
        assertThat(actualCount).isEqualTo(1);
    }

    // Below are the methods Just for implementing the assertJ core library's functions
    // implementing as() method
    @Test
    void testPersonCity(){
        assertThat(person.getPersonCity()).as("Check %s's city",person.getPersonName()).startsWith("G").
                endsWith("nagar").isNotNull();
    }

    // implementing withFailMessage() method
    @Test
    void testPersonName(){
        assertThat(person.getPersonName()).withFailMessage("The name must be Vyom").
                isEqualTo("Rahul");
    }

    
}