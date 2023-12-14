package org.example;
import org.example.model.Abstract.Product;
import org.example.Tools.IdGenerator;

public class Candy extends Product {

    private String productName;
    private String flavor;

    public Candy(String productName, int price, String flavor) {
        super(productName, price);
        this.flavor = flavor;
        this.id = IdGenerator.genId();
    }


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

    public int getId() {
        return this.id;
    }
}
