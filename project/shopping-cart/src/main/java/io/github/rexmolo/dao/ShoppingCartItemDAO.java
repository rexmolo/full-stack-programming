package io.github.rexmolo.dao;

import io.github.rexmolo.entities.ShoppingCart;
import io.github.rexmolo.entities.ShoppingCartItem;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartItemDAO {

    ShoppingCartItem save(ShoppingCartItem cart);
    Optional<ShoppingCartItem> findById(int id);
    List<ShoppingCartItem> findAll();
    List<ShoppingCartItem> findByCartId(int cartId);
    List<ShoppingCartItem> findByProductId(int productId);
    void delete(int id);
}
