package io.github.rexmolo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;

class PlainOld{
    private static int last_id = 1;
    private int id;
    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object id = " + id);
    }
}

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
//        ArrayList<String> aa = new ArrayList<>(List.of("a", "b"));
//        aa.removeIf(i -> i.equals("b"));
//        System.out.println(aa);
//        System.out.println(everySecondCharPrinter("0123456789", everySecondCharLambda));

//        printTheParts.accept("dddd fdfdf");


        //Method Reference;
//        PlainOld[] pojo = seedArray(PlainOld::new, 10);

        convenienceMethodsOnFunctionalInterfaces();
    }

    public static void convenienceMethodsOnFunctionalInterfaces() {
        String name = "Jackie";
        Function<String, String> uCase = String::toUpperCase;

        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Ma");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);

        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat( " Ma"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f2 = uCase
                .andThen(s -> s.concat(" Ma"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join("-", s));
        System.out.println(f2.apply(name));

        Function<String, Integer> f1 = uCase
                .andThen(s -> s.concat(" Ma"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f1.apply(name));
    }

    private static <T> void calculator(BinaryOperator<T> func, T v1, T v2) {

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




    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }

}
