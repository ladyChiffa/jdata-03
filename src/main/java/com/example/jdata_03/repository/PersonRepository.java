package com.example.jdata_03.repository;

import com.example.jdata_03.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // CrudRepository уже предоставляет методы CRUD

    public List<Person> findByCityOfLiving(String cityOfLiving);
    public List<Person> findByAgeLessThan(int age);
    public Optional<Person> findByNameAndSurname(String name, String surname);
}