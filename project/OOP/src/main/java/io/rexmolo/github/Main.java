package io.rexmolo.github;

public class Main {
    public static void main(String[] args) {



    }

    private static void runDice() {
        Dice[] Dices = Dice.values();

        for (Dice d : Dices) {
            System.out.printf("%s value is: %d \n", d, d.roll());
        }
    }
}