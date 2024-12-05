package com.msahoo.springbootaws.repository;

import com.msahoo.springbootaws.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Person person) {
        entityManager.merge(person);
        entityManager.flush();
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void deleteByID(long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
