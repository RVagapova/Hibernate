package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "persons", schema = "netology")
public class Person {
    @EmbeddedId
    private PersonId personId;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String city;

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                "}\n";
    }
}
