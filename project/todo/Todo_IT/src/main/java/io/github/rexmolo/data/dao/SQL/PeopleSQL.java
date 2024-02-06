package io.github.rexmolo.data.dao.SQL;

public class PeopleSQL {

    public static String FIND = "SELECT * FROM person WHERE ";
    public static String FINDBYFIRSTNAME = "SELECT * FROM person WHERE first_name like ?";
    public static String DELETEBY = "DELETE FROM person where ";
    public static String UPDATEBY = "UPDATE person SET first_name=?, last_name=? where ";

    public static String CREATE_PERSON = "INSERT INTO person (first_name, last_name) VALUES(?, ?)";

    public static String getFindSQL(String where) {
        return FIND + (" " + where + "=?");
    }

    public static String getUpdateSQL(String where) {
        return UPDATEBY + (" " + where + "=?");
    }

    public static String getDeleteSQL(String where) {return DELETEBY + (" " + where + "=?");}



}
