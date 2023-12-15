package io.rexmolo.github;

public class MiniCalculator implements Calculator {
    @Override
    public double addition(double a, double b) {
        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        return a / b;
    }

    @Override
    public void calculate(double a, double b, int operation) {
        Calculator.super.calculate(a, b, operation);
    }
}
