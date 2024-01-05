package io.github.rexmolo;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LambdaMiniChallenges {

    public static void main (String[] args) {

        //everySecondCharLambda
        Function<String, String> everySecondCharLambda = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(i % 2 == 1)
                    returnVal.append(source.charAt(i));
            }

            return returnVal.toString();
        };

        //everySecondCharLambda unaryOperator
        UnaryOperator<String> everySecondCharUnary = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(i % 2 == 1)
                    returnVal.append(source.charAt(i));
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharPrinter("0123456789", everySecondCharLambda));

//        printTheParts.accept("dddd fdfdf");
    }

    public static String everySecondCharPrinter(String source, Function<String, String> uo) {
        return uo.apply(source);
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if(i % 2 == 1)
                returnVal.append(source.charAt(i));
        }

        return returnVal.toString();
    }

    public static void lambdaEvolution() {

        //step 1
        Consumer<String> printTheParts = (sentence) -> {
            String[] parts = sentence.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        //step 2
        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
//            Arrays.asList(parts).forEach(s -> System.out.println(s));
            Arrays.asList(parts).forEach(System.out::println);
        };

        //step 3
        Consumer<String> printWrodsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(System.out::println);
        };
    }


}
