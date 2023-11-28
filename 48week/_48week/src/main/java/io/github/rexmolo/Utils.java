package io.github.rexmolo;

public class Utils {

    /**
     * Expected output: 11 23 39 etc.
     *
     * @param numberArr
     */
    public static void specialPrintNumbers(int[] numberArr) {
        char tt = '\t';
        String output = "";
        for (int i = 0, j = 0; i < numberArr.length; i++, j++) {
            if (j%2 == 0 && j != 0)
                output += tt;
            output += numberArr[i];
        }

        System.out.printf(output);
    }
}
