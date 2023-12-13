package org.example.model.Abstract;

public abstract class Product implements org.example.model.Interface.Product {

    protected int id;
    protected String productName;
    protected double price;
    protected String examine() {
        return "Candy{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }


    protected String use() {
        return "sweet~~";
    }



}
