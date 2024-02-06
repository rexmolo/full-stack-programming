package io.github.rexmolo.data.dao.impl;

import io.github.rexmolo.models.Person;
import io.github.rexmolo.sys.DB_Operation._MySQL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class PeopleDAOImplTest {

    PeopleDAOImpl pdo;
    Person person;

    int id = 7;

    @BeforeEach
    void setUp() {
        pdo = new PeopleDAOImpl(_MySQL.getInstance());
    }

    @Test
    void create() {
        person = new Person("AK", "Ma");
        Person p = pdo.create(person);
        person.setId(p.getId());
        assertNotNull(p);
    }

    @Test
    void findById() {
        assertNotNull(pdo.findById(id));
    }

    @Test
    void findByName() {
        person = new Person("AK", "Ma");
        Collection<Person> personCollection = pdo.findByName(person.getFirstName());
        assertNotNull(personCollection);
    }

    @Test
    void update() {
        person = new Person("AK47", "Ma_");
        person.setId(id);
        Person updated = pdo.update(person);
        assertEquals(updated, person);
    }

    @Test
    void deleteById() {
        Boolean actual = pdo.deleteById(id);
        assertEquals(true, actual);
    }
}