package com.person.persondemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person {

    @Id
    private int personId;
    private String personName;
    private String personCity;


    public int getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public Person(int personId, String personName, String personCity) {
        this.personId = personId;
        this.personName = personName;
        this.personCity = personCity;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personCity='" + personCity + '\'' +
                '}';
    }
}
