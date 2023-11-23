package io.github.rexmolo.miniCalculator;

import java.util.Arrays;
import java.util.Scanner;

public class Caculator {

    //    static String[] operations = {"-", "+", "/", "*"};

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void run() {

        while (true) {

            showUsage();
            int operation = getUserOperation();
            if (operation < 0) continue;

            try {
                promptMessage("please input the first number");
                double a = ScannerUtils.get().nextUserInputDouble();
                promptMessage("please input the second number");
                double b = ScannerUtils.get().nextUserInputDouble();

                doCalculation(a, b, operation);
            } catch (Exception e) {
                System.out.println("\u001B[31m" + e.getMessage());
            }


        }
    }

    public static int getUserOperation() {
        String userInput = ScannerUtils.get().nextUserInput();
        int[] operations = {1, 2, 3, 4};

        if (isQuit(userInput)) {
           sysMsg("Thanks Bye Bye~", true);
        }

System.out.println(Integer.parseInt(userInput));
        System.exit(0);

        
        if (!userInput.equals("q") && Arrays.binarySearch(operations, Integer.parseInt(userInput)) < 0){
            promptMessage(ANSI_RED + "please input valid operator" + ANSI_RESET);
            return -1;
        }
        return Integer.parseInt(userInput);
    }

    public static boolean isQuit(String userInput) {
        return userInput.equals("q");
    }

    public static void showUsage() {
        System.out.println("Simple Calculator");
        System.out.println("Press 1 to addition");
        System.out.println("Press 2 to subtraction");
        System.out.println("Press 3 to multiplication");
        System.out.println("Press 4 to division");
        System.out.println("Press q to quit");
        System.out.print("> ");
    }

    private static void promptMessage(String prompt){
        System.out.println(prompt);
        System.out.print("> ");
    }




    /**
     * if the user input is a number
     *
     * @param s
     * @return
     */
//    public static double isNumberic(String s) {
//
//        if (s == null) return -1;
//
//        try {
//            double b = Double.parseDouble(s);
//        } catch (NumberFormatException nfe) {
//            return -1;
//        }
//
//        return b;
//    }

    public static void doCalculation(double a, double b, int operation) {


        String tip = "result is: ";
        double result;
        switch (operation) {
            case 1:
                result = addition(a, b);
                break;
            case 2:
                result = subtraction(a, b);
                break;
            case 3:
                result = multiplication(a, b);
                break;
            case 4:
                result = division(a, b);
                break;
            default:
                result = -1;
                sysMsg("wrong operation", true);
        }

        System.out.println(tip + ANSI_GREEN + result + ANSI_RESET);
    }

    public static void sysMsg(String msg, boolean exitP) {
        if (exitP) {
            System.out.println(msg);
            System.exit(0);
        }
    }

    public static double addition(double a, double b) {

        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }
}
