package io.rexmolo.github;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Dice[] Dices = Dice.values();

        for (Dice d : Dices) {
            System.out.printf("%s value is: %d \n", d, d.roll());
        }
    }
}