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
        return entityManager.createQuery("select person from PersonInfo where cityOfLiving = :city",  Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
