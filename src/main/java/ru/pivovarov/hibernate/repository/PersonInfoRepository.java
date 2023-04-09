package ru.pivovarov.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pivovarov.hibernate.model.Person;
import ru.pivovarov.hibernate.model.PersonInfo;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Person> {

}
