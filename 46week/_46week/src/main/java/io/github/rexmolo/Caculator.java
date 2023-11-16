package io.github.rexmolo;

import java.util.Scanner;

public class Caculator {

    //    static String[] symbols = {"-", "+", "/", "*"};
    static String userInput;

    static Double b, a = null;
    static int symbol;
    static int userInputStepCounter = 0;

    static Scanner sn;

    public Caculator() {

    }

    public static void run() {
        sn = new Scanner(System.in);

        while (true) {

            showUsage();

            userInput = getNextUserInput();
            if (isQuit(userInput)) break;
            symbol = Integer.parseInt(userInput);

            try {
                System.out.println("please input the first number");
                a = getNextUserInputDouble();
                System.out.println("please input the second number");
                b = getNextUserInputDouble();

                doCalculate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
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
        System.out.println("> ");
    }

    /**
     * @return
     */
    public static String getNextUserInput() {
        return sn.next().trim();
    }

    public static double getNextUserInputDouble() {
        return sn.nextDouble();
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

    public static void doCalculate() {


        String tip = "result is: ";
        switch (symbol) {
            case 1:
                System.out.println(tip + addition(a, b));
                break;
            case 2:
                System.out.println(tip + subtraction(a, b));
                break;
            case 3:
                System.out.println(tip + multiplication(a, b));
                break;
            case 4:
                System.out.println(tip + division(a, b));
                break;
            default:
                sysMsg("wrong operation", true);
        }

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
