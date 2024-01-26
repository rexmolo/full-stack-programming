package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.Person;

import java.util.Collection;

public interface PeopleDAO extends BaseDAO<Person> {

    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);

}
