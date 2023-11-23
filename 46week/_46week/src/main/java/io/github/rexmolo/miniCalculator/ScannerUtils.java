package io.github.rexmolo.miniCalculator;

import java.util.Objects;
import java.util.Scanner;

public class ScannerUtils {

    public static ScannerUtils get;
    static Scanner sn;
    static ScannerUtils selfInstance;

    public ScannerUtils() {
        sn = new Scanner(System.in);
    }

    public static ScannerUtils get() {
        if (!Objects.isNull(selfInstance))
            return selfInstance;
        return new ScannerUtils();
    }

    /**
     * @return
     */
    public static String nextUserInput() {
        return sn.next().trim();
    }


    public static double nextUserInputDouble() {
        return sn.nextDouble();
    }
}
