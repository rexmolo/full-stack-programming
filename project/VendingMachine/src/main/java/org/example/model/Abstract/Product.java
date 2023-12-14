package org.example.model.Abstract;

public abstract class Product {

    public int id;
    protected String productName;
    protected int price;


    public Product(String productName, int price){
//        this();
        this.productName = productName;
        this.price = price;
    }

    public Product() {

    }

    public abstract int getId();


    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return this.price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

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
