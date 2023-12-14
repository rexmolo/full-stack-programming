package org.example;

import org.example.model.Abstract.Product;
import org.example.Tools.IdGenerator;

public class Drink extends Product {

    private String size;

    public Drink(String productName, int price, String size) {
        super(productName, price);
        this.id = IdGenerator.genId();
        this.size = size;
    }

    public int getId(){
        return this.id;
    }

}
