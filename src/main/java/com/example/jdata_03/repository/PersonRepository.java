package com.example.jdata_03.repository;

import com.example.jdata_03.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getByCity(String city) {
        return entityManager.createQuery(
                        "SELECT p FROM Person p WHERE city_of_living = :city",
                        Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
