package io.github.rexmolo;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_practice",
                    "root",
                    "mytest");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM product");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("price"));
            }
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
    }
}