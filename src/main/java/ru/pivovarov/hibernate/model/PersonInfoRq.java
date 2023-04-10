package ru.pivovarov.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonInfoRq {
    String name;
    String surname;
    int age;
    String phoneNumber;
    String cityOfLiving;
}
