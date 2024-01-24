package io.github.rexmolo;

import io.github.rexmolo.dao.impl.ProductDAOImpl;

public class Main {
    public static void main(String[] args) {
        ProductDAOImpl pdl = new ProductDAOImpl();
        pdl.findAll();
    }
}