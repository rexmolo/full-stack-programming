package io.github.rexmolo.data.dao.impl;

import io.github.rexmolo.config.DB_MySQL;
import io.github.rexmolo.data.dao.PeopleDAO;
import io.github.rexmolo.data.dao.SQL.PeopleSQL;
import io.github.rexmolo.exception.MySQLException;
import io.github.rexmolo.models.AppUser;
import io.github.rexmolo.models.Person;
import io.github.rexmolo.sys.DB_Operation._MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class PeopleDAOImpl implements PeopleDAO {

    private static _MySQL DB;

    public PeopleDAOImpl() {
        DB = _MySQL.getInstance();
    }

    @Override
    public AppUser persist(Person person) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Person create(Person person) {
        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(PeopleSQL.CREATE_PERSON);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            int personId = DB.create(preparedStatement);
            if (personId == -1)
                throw new MySQLException("create failed");
            Person p = new Person();
            p.setId(personId);
            p.setFirstName(person.getFirstName());
            p.setLastName(person.getLastName());

            return p;
        } catch (SQLException sqe) {
            throw new MySQLException(sqe.getMessage());
        }

    }

    @Override
    public Collection<Person> findAll() {
        ArrayList<Person> personLs = new ArrayList<>();

        try {
            ResultSet rs = DB.query("SELECT * FROM person");
            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt("person_id"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                personLs.add(p);
            }
            personLs.forEach(System.out::println);
            return personLs;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public Person findById(int id) {
        Person p = new Person();

        try {
            ResultSet rs = DB.preparedQuery("SELECT * FROM person where person_id=?", (PreparedStatement) -> {
                try {
                    PreparedStatement.setInt(1, id);
                } catch (SQLException e) {
                    throw new MySQLException(e.getMessage());
                }
                return PreparedStatement;
            });
            while (rs.next()) {
                p.setId(rs.getInt("person_id"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
            }
            return p;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public Collection<Person> findByName(String name) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {


        return false;
    }
}
