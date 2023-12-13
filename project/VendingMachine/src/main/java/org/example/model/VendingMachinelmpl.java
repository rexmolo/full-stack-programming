package org.example.model;

import org.example.model.Abstract.Product;
import org.example.model.Interface.VendingMatchine;

import java.util.Arrays;

public class VendingMachinelmpl implements VendingMatchine {

    private final int[] depositList = {1,2,5,10,20,50,100,200,500,1000};

    private int depositPool;

    public void addCurrency(int amount) {
        if (Arrays.binarySearch(this.depositList, amount) < 0){
            throw new IllegalArgumentException("Not allowed");
        }
        this.depositPool += amount;
    }

    public int getBalance() {
        return this.depositPool;
    }

    public Product request(int id) {
        return null;
    }

    public String getDescription(int id) {
        return null;
    }

    public String[] getProducts() {
        return new String[0];
    }
}
