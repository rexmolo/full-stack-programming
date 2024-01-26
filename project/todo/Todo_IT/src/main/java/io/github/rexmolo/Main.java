package io.github.rexmolo;


import io.github.rexmolo.data.dao.impl.PeopleDAOImpl;

public class Main {

    private static int id;
    public static void main(String[] args) {

        try {

//            String[] a = {"a"};

//            Person jackie = new Person(null, null, null);
//            Person jackie = new Person("", "Ma", null);
//            Person jackie = new Person("jackie", null, null);
//            Person jackie = new Person("jackie", null, "ttt@aa.com");
//            Person jackie = new Person("jackie", "Ma", "dddddf");

//            System.out.println(a[1]);

            PeopleDAOImpl pdo = new PeopleDAOImpl();
            pdo.findAll();


        } catch (IllegalArgumentException ilae) {
            System.out.println(ilae.getMessage());
        }

    }

}