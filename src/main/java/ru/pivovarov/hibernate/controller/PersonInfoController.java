package ru.pivovarov.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pivovarov.hibernate.model.Person;
import ru.pivovarov.hibernate.model.PersonInfo;
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
    public List<Person> getPersonsByCity() {
        return null;
    }

    @PutMapping("/person")
    @ResponseBody
    public PersonInfo createPersonInfo(String city) {
        return null;
    }
}
