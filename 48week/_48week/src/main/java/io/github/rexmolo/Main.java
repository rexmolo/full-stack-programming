package io.github.rexmolo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        String[] names = {"Fredrik"};
        String[] moreNames = {"Fredrik M", "Fredrik C", "Erik M", "Ulf D", "Simon D", "Kent F"};
//
//        String[] newArr = Arr.merge(names, moreNames);
//        System.out.println(Arrays.toString(newArr));

//        int[] a={5,6};
//        int[] newArr = Arr.append(a, 1,2,3);

//        Utils.specialPrintNumbers(newArr);

//

        NameRepository.setNames(moreNames);
//        NameRepository.clear();
//        String t = NameRepository.find("Fredrik M");

        NameRepository.add("simon a");

//       NameRepository.remove("Fredrik M");
        String[] n = NameRepository.findAll();
//
        System.out.println(Arrays.toString(n));
//        System.out.println(t);

//        int[] arr = {20, 20, 40, 20, 30, 40, 50, 60, 50};
//    Arr.filter(arr);

    }

    private static void exercises5() {
        String[][] worldcities =  {{"France", "Paris"}, {"Sweden", "Stockholm"}};

        for(int i = 0; i < worldcities.length; i++) {
            System.out.printf("%s\t%s\n", worldcities[i][0], worldcities[i][1]);
        }
    }


}