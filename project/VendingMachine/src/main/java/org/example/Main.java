package org.example;

import org.example.model.Abstract.Product;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Drink coke = new Drink("Coca Cola",200, "Small");
        Drink pepsi = new Drink("Pepsi",100, "Large");
        Candy sweet = new Candy("AABB",10, "Sweet");


        VendingMachinelmpl Impl = new VendingMachinelmpl();
        Impl.addProduct(coke);
        Impl.addProduct(pepsi);
        Impl.addProduct(sweet);

        System.out.println(Arrays.toString(Impl.getProducts()));



        Impl.addCurrency(100);


        Product pd = Impl.request(sweet.getId());

        System.out.println(Impl.getBalance());

    }
}