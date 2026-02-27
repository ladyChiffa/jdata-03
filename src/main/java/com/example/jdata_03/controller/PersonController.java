package com.example.jdata_03.controller;

import com.example.jdata_03.entity.Person;
import com.example.jdata_03.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getProductById(@RequestParam("city") String city) {
        return ResponseEntity.ok(personRepository.getByCity(city));
    }
}
