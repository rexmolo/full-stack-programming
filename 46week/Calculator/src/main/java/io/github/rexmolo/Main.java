package io.github.rexmolo;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String[] symbols = {"-", "+", "/", "*"};

    public static void main(String[] args) {

        String userInput;

        Scanner sn = new Scanner(System.in);


        Double b, a = null;
        String symbol = "";

        int counter = 0;
        while(true) {
            userInput = sn.next().trim();
            if (userInput.equals("exit")) {
               sysMsg("Exiting...", true);
            }


            if ((counter == 0 || counter == 2) && !isNumberic(userInput)) {
                sysMsg("Please input a number", false);
                continue;
            }


            if (counter == 0) {

                a = Double.parseDouble(userInput);
                counter++;
            } else if (counter == 1) {
//                if (!isSymbol(userInput)){
//                    sysMsg("please input \'+\' or \'-\' or \'/\' or \'*\'", false);
//                    continue;
//                }

                counter++;
                symbol = userInput;
            } else  {

                b = Double.parseDouble(userInput);
                counter = 0;
                doCalculate(a, symbol, b);
            }

        }

    }

    public static boolean isSymbol(String s) {
        for (int i = 0; i < symbols.length; i++) {
            if (s.equals(symbols[i]))
                return true;
        }
        return false;
    }

    public static void doCalculate(double a, String symbol, double b) {

        sysMsg(a + " " + symbol + " " + b, false);



        Double c = null;
        switch (symbol.toString()) {
            case "+":
                c = addition(a, b);
                System.out.println(c);
//                sysMsg(String.valueOf(c), false);
                break;
            case "-":
                c = substraction(a, b);
                System.out.println(c);
//                sysMsg(String.valueOf(c), false);
                break;
            case "/":
                c = division(a, b);
                System.out.println(c);
//                sysMsg(String.valueOf(c), false);
                break;
            case "*":
                c = multiplication(a, b);
                System.out.println(c);
//                sysMsg(String.valueOf(c), false);
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


    public static boolean isNumberic(String s) {

       if(s == null) return false;

       try{
           double b = Double.parseDouble(s);
       } catch (NumberFormatException nfe) {
           return false;
       }

       return true;
    }


    public static double addition(double a, double b) {

        return a + b;
    }

    public static double substraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }
}