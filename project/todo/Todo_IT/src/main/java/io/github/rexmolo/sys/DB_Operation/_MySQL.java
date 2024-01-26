package io.github.rexmolo.sys.DB_Operation;

import io.github.rexmolo.config.DB_MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class _MySQL{

    private Connection connection;
    private static _MySQL instance;


    private _MySQL() {
        this.connection = DB_MySQL.getConnection();
    }

    public static  _MySQL getInstance() {
        if (!Objects.isNull(instance))
            return instance;
        return new _MySQL();
    }


    public ResultSet query(String sql) {
        try {
            return this.connection.createStatement().executeQuery(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return null;
    }

    public Statement getPreparedQuery(String sql) {
        try {

            return this.connection.
                    prepareStatement(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return null;
    }

    public boolean create(String sql) {
       return this.execute(sql);
    }


    public boolean update(String sql) {
        return this.execute(sql);
    }

    public boolean delete(String sql) {
        return this.execute(sql);
    }

    public boolean execute(String sql) {
        try {
            return this.connection.createStatement().execute(sql);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        } finally {
            try{
                this.connection.close();
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
    }

}
