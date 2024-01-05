package io.github.rexmolo;

public class Product {

    private String productName;
    private double price;
    private int stock;

    public Product(String pName, double price, int stock) {
        this.setProductName(pName);
        this.setPrice(price);
        this.setStock(stock);
    }

    public Product() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
