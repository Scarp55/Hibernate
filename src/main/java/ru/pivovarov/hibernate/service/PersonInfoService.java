package ru.pivovarov.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.pivovarov.hibernate.model.Person;
import ru.pivovarov.hibernate.model.PersonInfo;
import ru.pivovarov.hibernate.model.PersonInfoRq;
import ru.pivovarov.hibernate.repository.PersonInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonInfoService {

    private final PersonInfoRepository personInfoRepository;

    public PersonInfo createPersonInfo(PersonInfoRq personInfoRq) {
        Person person = new Person();
        BeanUtils.copyProperties(personInfoRq, person);
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPerson(person);
        return copyPropertiesAndSave(personInfoRq, personInfo);
    }

    public List<PersonInfo> getPersonInfoByCity (String city) {
        return personInfoRepository.findPersonInfoByCityOfLiving(city);
    }

    public Optional<List<PersonInfo>> getPersonInfoByPerson_NameAndPerson_Surname(String name, String surname) {
        return personInfoRepository.findPersonInfoByPerson_NameAndPerson_Surname(name, surname);
    }

    public PersonInfo updatePersonInfo(PersonInfoRq personInfoRq) {
        Person oldPerson = new Person();
        BeanUtils.copyProperties(personInfoRq, oldPerson);
        PersonInfo personInfo = personInfoRepository.findPersonInfoByPerson(oldPerson);
        return copyPropertiesAndSave(personInfoRq, personInfo);
    }

    public void deletePersonInfoByPerson(PersonInfoRq personInfoRq) {
        Person person = new Person();
        BeanUtils.copyProperties(personInfoRq, person);
        personInfoRepository.deleteById(person);
    }

    public List<PersonInfo> getPersonInfoByPerson_AgeLessThanOrderByPerson_Age(int age){
        return personInfoRepository.findPersonInfoByPerson_AgeLessThanOrderByPerson_Age(age);
    }

    private PersonInfo copyPropertiesAndSave(PersonInfoRq personInfoRq, PersonInfo personInfo) {
        BeanUtils.copyProperties(personInfoRq, personInfo);
        personInfoRepository.save(personInfo);
        return personInfo;
    }
}
