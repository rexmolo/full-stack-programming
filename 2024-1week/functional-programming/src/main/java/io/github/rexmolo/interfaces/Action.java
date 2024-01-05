package io.github.rexmolo.interfaces;

import io.github.rexmolo.Product;

@FunctionalInterface
public interface Action {
    void execute(Product p);
}
