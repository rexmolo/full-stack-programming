package io.github.rexmolo.data.dao.SQL;

public class PeopleSQL {

    public static String findOne = "SELECT * FROM person WHERE ";
    public static String deleteOne = "DELETE FROM person where id=?";
    public static String updateBy = "UPDATE person SET first_name=?, last_name=? where ";

    public static String CREATE_PERSON = "INSERT INTO person (first_name, last_name) VALUES(?, ?)";

    public static String getFindSQL(String where) {
        return findOne + (" " + where + "=?");
    }

    public static String getUpdateSQL(String where) {
        return findOne + (" " + where + "=?");
    }



}
