// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.person.persondemo.entities.Person;
import com.person.persondemo.service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    private Person person1;

    private Person person2;


    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        person1 = new Person(123,"Vyom","Gandhinagar");
        person2 = new Person(456,"Parth","Ahmedabad");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetPerson() throws Exception {
        when(personService.getPersonById(123)).thenReturn(Optional.ofNullable(person1));

        mockMvc.perform(get("/person/123")).
                andDo(print()).
                andExpect(status().isOk());
    }

    @Test
    void getAllPerson() throws Exception {
        when(personService.getAllPerson()).thenReturn(List.of(person1,person2));
        mockMvc.perform(get("/person")).
                andDo(print()).
                andExpect(status().isOk());
    }

    @Test
    void testAddPerson() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String jsonPerson = ow.writeValueAsString(person1);

        when(personService.addPerson(person1)).thenReturn("Person Added");
        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content(jsonPerson)).andDo(print()).andExpect(status().isOk());
    }
}