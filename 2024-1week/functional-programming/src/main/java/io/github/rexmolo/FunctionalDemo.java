package io.github.rexmolo;

import io.github.rexmolo.interfaces.DoubleOperator;

public class FunctionalDemo {



    public static void main(String[] args) {

        System.out.println(caculator(6d, 3d, addition));
    }


    public static double caculator(double a, double b, DoubleOperator operator) {
        return operator.apply(a, b);
    }


     DoubleOperator subtraction = new DoubleOperator() {

        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    };

     static DoubleOperator addition = (a, b) -> a - b;

}
