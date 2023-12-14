package io.github.rexmolo;


public class Main {

    private static int id;
    public static void main(String[] args) {

        try {

            String[] a = {"a"};

//            Person jackie = new Person(null, null, null);
//            Person jackie = new Person("", "Ma", null);
//            Person jackie = new Person("jackie", null, null);
//            Person jackie = new Person("jackie", null, "ttt@aa.com");
//            Person jackie = new Person("jackie", "Ma", "dddddf");

            System.out.println(a[1]);



        } catch (IllegalArgumentException ilae) {
            System.out.println(ilae.getMessage());
        }

    }

}