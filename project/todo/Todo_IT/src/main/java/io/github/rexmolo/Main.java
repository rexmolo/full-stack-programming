package io.github.rexmolo;


import io.github.rexmolo.data.dao.impl.PeopleDAOImpl;
import io.github.rexmolo.models.Person;

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
            Person p = pdo.create(new Person("AK", "Ma"));
//            pdo.findById(1);
//            System.out.println(pdo.findById(2));
            System.out.println(p.toString());


        } catch (IllegalArgumentException ilae) {
            System.out.println(ilae.getMessage());
        }

    }

}