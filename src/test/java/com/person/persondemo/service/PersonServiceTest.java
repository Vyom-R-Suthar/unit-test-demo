// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo.service;

import com.person.persondemo.entities.Person;
import com.person.persondemo.repository.PersonRepository;
import net.bytebuddy.dynamic.DynamicType;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Optionals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    private AutoCloseable autoCloseable;

    private Person person;

    @BeforeEach
    void setUp() {
        autoCloseable  = MockitoAnnotations.openMocks(this);
        personService = new PersonService(personRepository);
        person = new Person(456,"Rahul","Mahuva");
        System.out.println(personRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateUser() {
        when(personRepository.save(person)).thenReturn(person);
        assertThat(personService.createUser(person)).isEqualTo(person);
    }

    @Test
    void getPersonById() {
        Optional<Person> optionalPerson = Optional.of(person);
        System.out.println(optionalPerson);
        when(personRepository.findById(person.getPersonId())).thenReturn(optionalPerson);
        assertThat(personService.getPersonById(456)).isEqualTo(optionalPerson);
    }

    @Test
    void testGetAllPerson() {
        when(personRepository.findAll()).thenReturn(List.of(person));
        assertThat(personService.getAllPerson()).isEqualTo(List.of(person));
    }


    @Test
    void testDeleteAll() {
        doAnswer(Answers.CALLS_REAL_METHODS).when(personRepository).deleteAll();
        assertThat(personService.deleteAll()).isEqualTo("Success");
    }


    @Test
    void deletePersonById() {
        doAnswer(Answers.CALLS_REAL_METHODS).when(personRepository).deleteById(any());
        assertThat(personService.deletePersonById(456)).isEqualTo("Success");
    }

    @Test
    void testAddPerson(){
        when(personRepository.save(person)).thenReturn(person);
        assertThat(personService.addPerson(person)).isEqualTo("Person Added");
    }
}