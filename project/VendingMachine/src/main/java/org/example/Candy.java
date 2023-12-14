package org.example;
import org.example.model.Abstract.Product;
import org.example.Tools.IdGenerator;

public class Candy extends Product {

    private String flavor;

    public Candy(String productName, int price, String flavor) {
        super(productName, price);
        this.flavor = flavor;
        this.id = IdGenerator.genId();
    }

    public String getFlavor() {
        return flavor;
    }

    public int getId() {
        return this.id;
    }
}
