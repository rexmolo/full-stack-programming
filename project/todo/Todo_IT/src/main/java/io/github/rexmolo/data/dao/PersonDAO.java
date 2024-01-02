package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.Person;

public interface PersonDAO extends BaseDAO<Person> {
    Person findById(int id);
    Person findByEmail(String email);
}
