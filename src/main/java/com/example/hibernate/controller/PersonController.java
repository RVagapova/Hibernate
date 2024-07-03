package com.example.hibernate.controller;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public String personByCity(@RequestParam String city) {
        List<Person> personsByCity = personRepository.findByCity(city);
        return personsByCity.toString();
    }

    @GetMapping("/persons/by-age-less-than")
    public String personByAgeLessThan(@RequestParam int age) {
        List<Person> personByAgeLessThan = personRepository.findByPersonIdAgeLessThanOrderByPersonIdAgeAsc(age);
        return personByAgeLessThan.toString();
    }

    @GetMapping("/persons/by-name-surname")
    public String findByPersonIdNameAndPersonIdSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> personsByNameAndSurname = personRepository.findByPersonIdNameAndPersonIdSurname(name, surname);
        if (personsByNameAndSurname.isPresent()) {
            return personsByNameAndSurname.toString();
        } else {
            return "ничего не найдено";
        }
    }
}
