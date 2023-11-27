package io.github.rexmolo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        String[] names = {"Fredrik"};
        String[] moreNames = {"Fredrik", "Erik", "Ulf", "Simon", "Kent"};

        String[] newArr = Arr.merge(names, moreNames);
        System.out.println(Arrays.toString(newArr));
    }
}