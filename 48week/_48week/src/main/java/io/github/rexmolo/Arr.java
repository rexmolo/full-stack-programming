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

    /**
     * Write a program which will store elements in an array of type ‘int’ and print it out.
     * Expected output: 11 23 39 etc.
     *
     * @param arr
     * @param nums
     * @return
     */
    public static int[] append(int[] arr, int... nums) {
        // if (num == null) return //how to check num in java and if num not exist what should I return.
        return merge(arr, nums);
    }

    /**
     * Create a program and create a method with name ‘indexOf’ which will find and return the index of an element in the array. If the element doesn’t exist your method should return -1 as value.
     * Expected output: Index position of number 5 is: 2.
     *
     * @param hystack
     * @param needle
     * @return
     */
    public static int indexOf(String[] hystack, String needle) {
        for (int i = 0; i < hystack.length; i++) {
            if (hystack[i].equalsIgnoreCase(needle))
                return i;
        }
        return -1;
    }

    /**
     *
     * @param hystack
     * @param needle
     * @return
     */
    public static int indexOf(int[] hystack, int needle) {
        for (int i = 0; i < hystack.length; i++) {
            if (hystack[i] == needle)
                return i;
        }
        return -1;
    }

    /**
     * Write a program which will sort string array.
     * Expected output: String array: [Paris, London, New York, Stockholm]
     * Sort string array: [London, New York, Paris, Stockholm]
     *
     * @param arr
     * @return
     */
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

    public static int[] copyOf(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    /**
     * Write a program which will remove the duplicate elements of a given array [20, 20, 40, 20, 30, 40, 50, 60, 50].
     *
     * @param arr
     * @return
     */
    public static int[] filter(int[] arr) {
        int[] newArr = new int[]{};

        for (int i = 0; i < arr.length; i++) {
            if (indexOf(newArr, arr[i]) >= 0)
                continue;
            newArr = merge(newArr, new int[]{arr[i]});
        }

        return newArr;
    }
}
