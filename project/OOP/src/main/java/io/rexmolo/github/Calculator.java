package io.rexmolo.github;

import java.util.Arrays;
import java.util.Scanner;

public interface Calculator {

   String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";

    Scanner sn = new Scanner(System.in);

    double addition(double a, double b);
    double subtraction(double a, double b);
    double multiplication(double a, double b);
    double division(double a, double b);

    static double[] takeUserInput() {
        double[] input = new double[0];
        try {
            promptMessage("please input the first number");
            double a = sn.nextDouble();
            promptMessage("please input the second number");
            double b = sn.nextDouble();
            input = new double[]{a, b};

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return input;

    }

    default void calculate(double a, double b, int operation) {
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
                System.out.println("wrong operation");
        }

        System.out.println(tip + ANSI_GREEN + result + ANSI_RESET);
    }

    private static void promptMessage(String prompt){
        System.out.println(prompt);
        System.out.print("> ");
    }
}
