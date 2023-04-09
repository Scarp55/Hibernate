package ru.pivovarov.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pivovarov.hibernate.model.Person;
import ru.pivovarov.hibernate.repository.PersonInfoRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonInfoController {

    final PersonInfoRepository personInfoRepository;

    public PersonInfoController(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

    @GetMapping("/by-city")
    @ResponseBody
    public List<Person> getPersonsByCity(String city) {
        return personInfoRepository.getPersonsByCity(city);
    }
}
