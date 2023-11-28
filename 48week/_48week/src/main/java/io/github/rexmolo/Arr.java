package io.github.rexmolo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Arr {

    public static String[] merge(String[] arr1, String[] arr2) {
        String [] newArr = Arrays.copyOf(arr1, arr1.length + arr2.length);
        for (int i = arr1.length, j=0; i < newArr.length; i++, j++){
            newArr[i] = arr2[j];
        }
        return newArr;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int [] newArr = Arrays.copyOf(arr1, arr1.length + arr2.length);
        for (int i = arr1.length, j=0; i < newArr.length; i++, j++){
            newArr[i] = arr2[j];
        }
        return newArr;
    }

    public static int[] append(int[] arr, int... nums) {
        // if (num == null) return //how to check num in java and if num not exist what should I return.
        return merge(arr, nums);
    }

    public static int indexOf(String[] hystack, String needle) {
        for (int i = 0; i < hystack.length; i++) {
            if (hystack[i].equalsIgnoreCase(needle))
                return i;
        }
        return -1;
    }

    public static String[] sort(String[] arr) {
       for (int i = 0; i < arr.length; i++) {
           for (int j = i+1; j < arr.length; j++) {

               if (arr[i].compareToIgnoreCase(arr[j]) > 0){
                   String temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }

           }
       }

       return arr;
    }

}
