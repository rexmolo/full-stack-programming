package io.github.rexmolo;

import java.util.Arrays;

public class Arr {

    public static String[] merge(String[] arr1, String[] arr2) {
        String [] newArr = Arrays.copyOf(arr1, arr1.length + arr2.length);
        for (int i = arr1.length, j=0; i < newArr.length; i++, j++){
            newArr[i] = arr2[j];
        }
        return newArr;
    }
}
