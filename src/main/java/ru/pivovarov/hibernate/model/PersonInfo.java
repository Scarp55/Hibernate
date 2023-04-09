package ru.pivovarov.hibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {
    @EmbeddedId
    private Person person;
    private String phoneNumber;
    private String cityOfLiving;
}
