package ru.pivovarov.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pivovarov.hibernate.model.Person;
import ru.pivovarov.hibernate.model.PersonInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Person> {

    PersonInfo findPersonInfoByPerson(Person person);

    Optional<List<PersonInfo>> findPersonInfoByPerson_NameAndPerson_Surname(String name, String surname);

    List<PersonInfo> findPersonInfoByCityOfLiving(String city);

    List<PersonInfo> findPersonInfoByPerson_AgeLessThanOrderByPerson_Age(Integer age);
}
