package io.github.rexmolo.dao;

import io.github.rexmolo.conf.DB_ConfigMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DB_Connection {

    private static Connection connection = null;

    public static Connection getMySQLConnection() {
        try {

            if (!Objects.isNull(connection))
                return connection;


            return connection = DriverManager.getConnection(DB_ConfigMySQL.host + DB_ConfigMySQL.dbname,
                    DB_ConfigMySQL.uname,
                    DB_ConfigMySQL.password);
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        return connection;
    }
}
