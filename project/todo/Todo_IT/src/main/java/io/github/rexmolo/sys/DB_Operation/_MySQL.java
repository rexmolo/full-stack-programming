package io.github.rexmolo.sys.DB_Operation;

import io.github.rexmolo.config.DB_MySQL;
import io.github.rexmolo.exception.MySQLException;

import java.sql.*;
import java.util.Objects;
import java.util.function.Function;

public class _MySQL{

    private Connection connection;
    private static _MySQL instance = null;


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

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }


    public ResultSet executePreparedQuery(PreparedStatement preparedStatement) throws SQLException {
            return preparedStatement.executeQuery();
    }

    public int update(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeUpdate(); //rows affected
    }

    public int delete(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeUpdate(); //rows affected
    }

    public int create(PreparedStatement preparedStatement) throws SQLException {
        int rowsAffected = preparedStatement.executeUpdate();
        return this.getGeneratedKey(preparedStatement);
    }



    private int getGeneratedKey(PreparedStatement preparedStatement) throws SQLException {
        try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
        return -1;
    }



//    public ResultSet preparedQuery(String sql, Function<PreparedStatement, PreparedStatement> setParameters) throws SQLException {
//            return setParameters.apply(this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)).executeQuery();
//    }
//
//    public int d(String sql, int reType) throws SQLException {
//        int re;
//        PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        int rowsAffected = preparedStatement.executeUpdate();
//        this.connection.close();
//        re = switch (reType) {
//            case 1 -> rowsAffected;
//            case 2 -> this.getGeneratedKey(preparedStatement);
//            default -> -1;
//        };
//        return re;
//    }


}
