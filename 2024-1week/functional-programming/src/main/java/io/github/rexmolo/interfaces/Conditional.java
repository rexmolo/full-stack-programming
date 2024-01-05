package io.github.rexmolo.interfaces;

import io.github.rexmolo.Product;

@FunctionalInterface
public interface Conditional {
    boolean test(Product p);
}
