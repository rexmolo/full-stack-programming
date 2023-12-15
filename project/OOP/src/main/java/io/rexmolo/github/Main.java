package io.rexmolo.github;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cal.run();

    }


    private static class Cal {

        private static void run() {
            showUsage();
            int operation = getUserOperation();

            MiniCalculator cc = new MiniCalculator();

            double[] input = Calculator.takeUserInput();
            cc.calculate(input[0], input[1], operation);
        }

        static int getUserOperation() {
            String userInput = Calculator.sn.next().trim();
            int[] operations = {1, 2, 3, 4};

            if (userInput.equals("q")) {
                System.out.println("Thanks Bye Bye~");
                System.exit(0);
            }

            if (!userInput.equals("q") && Arrays.binarySearch(operations, Integer.parseInt(userInput)) < 0){
                promptMessage("please input valid operator");
                return -1;
            }
            return Integer.parseInt(userInput);
        }

        private static void promptMessage(String prompt){
            System.out.println(prompt);
            System.out.print("> ");
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
    }



    private static void runDice() {
        Dice[] Dices = Dice.values();

        for (Dice d : Dices) {
            System.out.printf("%s value is: %d \n", d, d.roll());
        }
    }
}