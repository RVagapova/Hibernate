package com.example.hibernate.repositories;

import com.example.hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p from Person p where p.city = :city")
    List<Person> findByCityJpql(String city);

    @Query("select p from Person p where p.personId.age < :age order by p.personId.age asc")
    List<Person> findByAgeLessJpql(int age);

    @Query("select p from Person p where p.personId.name = :name and p.personId.surname = :surname")
    Optional<Person> findByNameAndSurname(String name, String surname);
}
