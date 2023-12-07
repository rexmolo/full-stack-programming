package io.github.rexmolo;

import java.util.ArrayList;
import java.util.List;

public class ArrList {

    public static void main(String[] args) {

        listExample();
    }

    public static void listExample() {
        String[] books = {"one", "two", "three"};
        List booksList = List.of(books);
        // can not call booksList.add();
        //should like below
        ArrayList<String> bookArrList = new ArrayList<>(booksList);
        bookArrList.add("four");

        ArrayList<String> nextBookArrList = new ArrayList<>(
                List.of("five", "six" , "seven")
        );
        bookArrList.addAll(nextBookArrList);

        bookArrList.removeAll(List.of("three", "seven"));
        bookArrList.retainAll(List.of("four", "one"));

        bookArrList.clear();

        bookArrList.isEmpty();

        System.out.println(bookArrList);
    }
}
