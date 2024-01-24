package io.github.rexmolo.dao;

import io.github.rexmolo.entities.Product;
import io.github.rexmolo.entities.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {
    ShoppingCart save(ShoppingCart cart);
    Optional<ShoppingCart> findById(int id);
    List<ShoppingCart> findAll();
    List<ShoppingCart> findByOrderStatus(boolean status);
    List<ShoppingCart> findByReference(String customer);
    void delete(int id);
}
