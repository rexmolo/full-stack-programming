package io.github.rexmolo.entities;

public class ShoppingCartItem {
    private int id;
    private int amount;
    private Product item;
    private ShoppingCart cart;

    public ShoppingCartItem(int id, int amount, Product item, ShoppingCart cart) {
        this.id = id;
        this.amount = amount;
        this.item = item;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
