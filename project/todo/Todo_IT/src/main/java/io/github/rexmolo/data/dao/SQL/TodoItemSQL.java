package io.github.rexmolo.data.dao.SQL;

public class TodoItemSQL {
    public static String CREATE = "INSERT INTO person (title, description, deadline, done, assignee_id) VALUES(?, ?, ?, ?, ?)";
    public static String UPDATE = "UPDATE person SET title=?, description=?, deadline=?, done=?, assignee_id=? WHERE ";
    public static String SELECT = "SELECT * FROM todo_item ";
public static String DELETE = "DELETE FROM todo_item WHERE";


    public static String getFindSQL(String where) {
        return SELECT + (" WHERE " + where + "=?");
    }

    public static String getUpdateSQL(String where) {
        return UPDATE + (" " + where + "=?");
    }

    public static String getDeleteSQL(String where) {return DELETE + (" " + where + "=?");}

}
