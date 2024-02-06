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
import java.util.Objects;


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

            if (personId == -1)  throw new MySQLException("create failed");

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
            return getPeople(personLs, rs);
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public Person findById(int id) {
        Person p = new Person();
        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(PeopleSQL.getFindSQL("id"));
            preparedStatement.setInt(1, id);
            ResultSet rs = DB.executePreparedQuery(preparedStatement);

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
        ArrayList<Person> personLs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(PeopleSQL.getFindSQL("name"));
            preparedStatement.setString(1, name);
            ResultSet rs = DB.executePreparedQuery(preparedStatement);

            return getPeople(personLs, rs);
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    private Collection<Person> getPeople(ArrayList<Person> personLs, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Person p = new Person();
            p.setId(rs.getInt("person_id"));
            p.setFirstName(rs.getString("first_name"));
            p.setLastName(rs.getString("last_name"));
            personLs.add(p);
        }
        personLs.forEach(System.out::println);
        return personLs;
    }

    @Override
    public Person update(Person person) {

        if (Objects.isNull(person)) throw new IllegalArgumentException("empty data not allowed");

        Person foundPerson = this.findById(person.getId());
        if (Objects.isNull(foundPerson)) throw new IllegalArgumentException("could not find this person");

        if (person.equals(foundPerson)) return person;

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(PeopleSQL.getUpdateSQL("id"));

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getId());
            int rowsAffected = DB.update(preparedStatement);

            if (rowsAffected == 0) throw new MySQLException("update failed");

            return person;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {


        return false;
    }
}
