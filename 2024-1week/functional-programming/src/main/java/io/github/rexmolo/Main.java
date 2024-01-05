package io.github.rexmolo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

//        System.out.println(objData("product1", 10d, 10));
        ArrayList<Product> pls = new ArrayList<>();
        pls.add(new Product("product1", 100d, 7));
        pls.add(new Product("Bproduct2", 150d, 20));
        pls.add(new Product("product3", 155d, 100));
        pls.add(new Product("Bproduct4", 40d, 10));
        pls.add(new Product("product5", 50d, 0));

        Consumer<Product> cFunc = System.out::println;

        Predicate<Product> isZeroStock = p -> p.getStock() == 0;
        System.out.println("zero stock ===>");
        printZeroStock(isZeroStock, cFunc, pls);
//        pls.forEach(System.out::println);


        System.out.println("name starts with B ==> ");
        Predicate<Product> startWithB = p -> p.getProductName().startsWith("B");
        printZeroStock(startWithB, cFunc, pls);

        System.out.println("price above 100 and lower than 150 ==> ");
        Predicate<Product> priceBetween100_150 = p -> p.getPrice() >=100 && p.getPrice()<=150;
        printZeroStock(priceBetween100_150, cFunc, pls);

        Predicate<Product> stockValueLess = product -> product.getStock() < 10 && product.getStock() > 0;
        Consumer<Product> changePriceByStock = p -> {
            if (stockValueLess.test(p)) p.setPrice(p.getPrice() + p.getPrice() * 0.5);
        };

        changePriceBy(changePriceByStock, pls);
        System.out.println("changed price =====>");
        pls.forEach(System.out::println);
    }


    private static void changePriceBy(Consumer<Product> func, ArrayList<Product> pls) {
        pls.forEach(func);
    }

    private static void printZeroStock(Predicate<Product> pFunc, Consumer<Product> cFunc, ArrayList<Product> pls) {
        pls.forEach(p -> {
            if(pFunc.test(p))
                cFunc.accept(p);
        });
    }





}