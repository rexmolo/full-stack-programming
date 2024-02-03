package io.github.rexmolo.exception;

import java.sql.SQLException;

public class MySQLException extends RuntimeException{
    public MySQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public MySQLException(String message) {
        super(message);
    }

    public MySQLException() {
    }

}
