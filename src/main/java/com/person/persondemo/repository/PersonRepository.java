// Jai Swaminarayan KESHAV, Swami-Shreeji
package com.person.persondemo.repository;

import com.person.persondemo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("select case when count(p) > 0 then true else false end from Person p where p.personId = :id")
    boolean isPersonExistById(Integer id);

    Person findByPersonName(String personName);

    @Query(value = "select count(*) from persons",nativeQuery = true)
    int getTotalPerson();
}
