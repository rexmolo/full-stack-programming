package io.github.rexmolo.data.dao.SQL;

public class PeopleSQL {

    public static String findOne = "SELECT * FROM person WHERE ";
    public static String deleteOne = "DELETE FROM person where id=?";

    public static String CREATE_PERSON = "INSERT INTO person (first_name, last_name) VALUES(?, ?)";

    public static String getSQLFindByWhere(String where) {
        return findOne + (" " + where + "=?");
    }



}
