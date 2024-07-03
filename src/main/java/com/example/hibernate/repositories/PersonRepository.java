package com.example.hibernate.repositories;

import com.example.hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCity(String city);

    List<Person> findByPersonIdAgeLessThanOrderByPersonIdAgeAsc(int age);

    Optional<Person> findByPersonIdNameAndPersonIdSurname(String name, String surname);
}
