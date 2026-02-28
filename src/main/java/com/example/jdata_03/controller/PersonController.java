package com.example.jdata_03.controller;

import com.example.jdata_03.entity.Person;
import com.example.jdata_03.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getPersonAll() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable int id) {
        return ResponseEntity.ok(personRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> createProduct(@RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getPersonByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(personRepository.findByCityOfLiving(city));
    }

    @GetMapping("/by-age-max")
    public ResponseEntity<List<Person>> getPersonByAgeMax(@RequestParam("age") int age) {
        return ResponseEntity.ok(personRepository.findByAgeLessThan(age));
    }

    @GetMapping("/by-full-name")
    public ResponseEntity<Optional<Person>> getPersonByFullName(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return ResponseEntity.ok(personRepository.findByNameAndSurname(name, surname));
    }


}
