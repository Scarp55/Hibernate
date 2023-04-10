package ru.pivovarov.hibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonInfo {
    @EmbeddedId
    private Person person;
    private String phoneNumber;
    private String cityOfLiving;
}
