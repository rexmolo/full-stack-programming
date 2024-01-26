package io.github.rexmolo.data.dao.impl;

import io.github.rexmolo.data.dao.PeopleDAO;
import io.github.rexmolo.models.AppUser;
import io.github.rexmolo.models.Person;
import io.github.rexmolo.sys.DB_Operation._MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

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
        return null;
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
            System.out.println(e.getMessage());
        }
        return personLs;
    }

    @Override
    public Person findById(int id) {
        Person p = new Person();

        try {
            Function<PreparedStatement, PreparedStatement> setParameters = (PreparedStatement) -> {
                try {
                    PreparedStatement.setInt(1, id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return PreparedStatement;
            };

            ResultSet rs = DB.preparedQuery("SELECT * FROM person where person_id=?", setParameters);
            while (rs.next()) {
                p.setId(rs.getInt("person_id"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
            }
            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return p;
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
