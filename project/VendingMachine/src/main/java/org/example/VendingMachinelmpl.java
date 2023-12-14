package org.example;

import org.example.model.Abstract.Product;
import org.example.model.Interface.VendingMatchine;

import java.util.ArrayList;
import java.util.Arrays;

public class VendingMachinelmpl implements VendingMatchine {

    ArrayList<Product> products;

    private final int[] depositList = {1,2,5,10,20,50,100,200,500,1000};

    private int depositPool;

    public VendingMachinelmpl() {
        this.products = new ArrayList<>();
    }

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

        Product expectedProduct = this.getProduct(id);

        if (this.depositPool >= expectedProduct.getPrice()){
            this.depositPool -= expectedProduct.getPrice();
            return expectedProduct;
        } else {
            throw new IllegalArgumentException("You need more money");
        }

    }


    public int endSession() {
        int dp = this.depositPool;
        this.depositPool = 0;
        return dp;
    }


    public String getDescription(int id) {
        String s  = "";
        for(Product p : this.products){
            if (p.getId() == id)
                return s += "productId: " + p.getId() + " ProductName: " + p.getProductName() + " ProductPrice: " + p.getPrice() + "\n";

        }
        return s;
    }

    private Product getProduct(int id) {
        for(Product p : this.products){
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Illegal product");
    }

    public String[] getProducts() {
        String[] s = {};
        for(Product p : this.products){
            s = Arrays.copyOf(s, s.length + 1);
            String productStr =  "productId: " + p.getId() + " ProductName: " + p.getProductName() + " ProductPrice: " + p.getPrice() + "\n";
            s[s.length - 1] = productStr;
        }
        return s;
    }


    public void addProduct(Product product){
        this.products.add(product);
    }
}
