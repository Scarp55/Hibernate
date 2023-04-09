package ru.pivovarov.hibernate.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Person implements Serializable {

    private String name;
    private String surname;
    private String age;
}
