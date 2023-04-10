package ru.pivovarov.hibernate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.pivovarov.hibernate.model.PersonInfo;
import ru.pivovarov.hibernate.model.PersonInfoRq;
import ru.pivovarov.hibernate.service.PersonInfoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonInfoController {

    private final PersonInfoService personInfoService;

    @PostMapping("/person")
    public PersonInfo createPersonInfo(@RequestBody PersonInfoRq personInfoRq) {
        return personInfoService.createPersonInfo(personInfoRq);
    }

    @GetMapping("/NameSurname")
    public Optional<List<PersonInfo>> getPersonInfoByName(@RequestParam String name,
                                                          @RequestParam String surname) {
        return personInfoService.getPersonInfoByPerson_NameAndPerson_Surname(name, surname);
    }

    @GetMapping("/by-city")
    public List<PersonInfo> getPersonsByCity(@RequestParam String city) {
        return personInfoService.getPersonInfoByCity(city);
    }

    @GetMapping("/age")
    public List<PersonInfo> getPersonsByAge(@RequestParam int age) {
        return personInfoService.getPersonInfoByPerson_AgeLessThanOrderByPerson_Age(age);
    }

    @PutMapping("/person")
    public PersonInfo updatPersonInfo(@RequestBody PersonInfoRq personInfoRq) {
        return personInfoService.updatePersonInfo(personInfoRq);
    }

    @DeleteMapping("/person")
    public void deletePersonInfo(@RequestBody PersonInfoRq personInfoRq) {
        personInfoService.deletePersonInfoByPerson(personInfoRq);
    }
}
