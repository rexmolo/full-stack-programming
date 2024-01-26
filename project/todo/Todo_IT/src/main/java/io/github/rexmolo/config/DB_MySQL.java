package io.github.rexmolo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public final class DB_MySQL {

    public static String uname = "root";
    public static String password = "mytest";
    public static String dbname = "todoit";
    public static String host = "jdbc:mysql://localhost:3306/";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {

            if (!Objects.isNull(connection))
                return connection;


            return connection = DriverManager.getConnection(host + dbname,
                    uname,
                    password);
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        return connection;
    }
}
