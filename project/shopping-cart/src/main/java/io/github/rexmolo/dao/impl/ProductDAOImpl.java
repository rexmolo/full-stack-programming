package io.github.rexmolo.dao.impl;

import io.github.rexmolo.dao.DB_Connection;
import io.github.rexmolo.dao.ProductDAO;
import io.github.rexmolo.entities.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {

    private static Connection connection;

    public ProductDAOImpl() {
        connection = DB_Connection.getMySQLConnection();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM product");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByPriceBetween(double low, double high) {
        return null;
    }

    @Override
    public void delete(int id) {

    }


}
