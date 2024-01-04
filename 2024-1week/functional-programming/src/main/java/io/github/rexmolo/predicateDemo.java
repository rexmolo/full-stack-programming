package io.github.rexmolo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class predicateDemo {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        Predicate<Integer> isEven = number -> number % 2 == 0;


        System.out.println(filter(numbers, isEven));
    }


    public static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filteredList = new ArrayList<>();
        for (int number: numbers) {
            if(predicate.test(number)) filteredList.add(number);
        }

        return filteredList;
    }
}
