package ru.pivovarov.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.pivovarov.hibernate.model.Person;

import java.util.List;

@Repository
public class PersonInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city){
        String query = "select person from PersonInfo where city_of_living=" + "'" + city + "'";
        List<Person> personList = entityManager.createQuery(query,  Person.class).getResultList();
        for (Person person : personList) {
            System.out.println(person.toString());
        }
        return personList;
    }
}
