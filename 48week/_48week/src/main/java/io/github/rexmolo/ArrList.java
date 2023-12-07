package io.github.rexmolo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record Person(String firstName, String lastName, int id) {
    public Person(String firstName, String lastName) {

        this(firstName, lastName, 1);
    }
}

public class ArrList {

    public static void main(String[] args) {

        listObjectExample();
    }

    public static void listStringExample() {
        String[] books = {"one", "two", "three"};
        List booksList = List.of(books);
        // can not call booksList.add();
        //should like below
        ArrayList<String> bookArrList = new ArrayList<>(booksList);
        bookArrList.add("four");

        ArrayList<String> nextBookArrList = new ArrayList<>(
                List.of("five", "six" , "seven")
        );

        bookArrList.addAll(Arrays.asList("eggs", "cooking"));

        bookArrList.addAll(nextBookArrList);

        bookArrList.sort(Comparator.naturalOrder());
        bookArrList.sort(Comparator.reverseOrder());

        //change to array
        String[] bookArr = bookArrList.toArray(new String[bookArrList.size()]);

//        bookArrList.removeAll(List.of("three", "seven"));
//        bookArrList.retainAll(List.of("four", "one"));

//        bookArrList.clear();

//        bookArrList.isEmpty();

//        System.out.println(bookArrList);
        System.out.println(Arrays.toString(bookArr));
    }

    public static void listObjectExample() {
        Person[] pl = new Person[]{};

        ArrayList<Person> pall = new ArrayList<>(List.of(pl));
        pall.add(new Person("jackie", "Ma"));
        pall.add(new Person("Goo", "T"));

        pl = pall.toArray(new Person[pall.size()]);

//        System.out.println(pall);
        System.out.println(Arrays.toString(pl));

    }
}
