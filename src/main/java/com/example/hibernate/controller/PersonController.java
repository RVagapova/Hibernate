package com.example.hibernate.controller;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public String personByCity(@RequestParam String city) {
        List<Person> personsByCity = personRepository.getPersonsByCity(city);
        return personsByCity.toString();
    }
}
