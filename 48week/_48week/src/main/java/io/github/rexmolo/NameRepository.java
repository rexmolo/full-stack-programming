package io.github.rexmolo;

import java.util.Arrays;

public class NameRepository {

    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    };

    public static void setNames(String[] names) {
        NameRepository.names = names;
    }

    public static void clear() {
        String[] temp = new String[0];
        names = temp;
    }

    public static String[] findAll() {
        return names;
    }

    public static String find(final String fullname) {
        for (String name: names) {
            if (name.equalsIgnoreCase(fullname))
                return name;
        }
        return null;
    }

    public static boolean add(final String fullname) {
        if (find(fullname) != null) return false; //found
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullname;
        return true;
    }

    public static String[] findByFirstName(final String fistName) {
        String[] found = new String[0];
        for (int i = 0; i < names.length; i++) {
            String[] fullName = names[i].split(" ");
            if (!fullName[0].equalsIgnoreCase(fistName))
                continue;
            String[] newFound = {names[i]};
            found = Arr.merge(found, newFound);
        }
        return found;
    }

    public static String[] findByLastName(final String lastName) {
        String[] found = new String[0];
        for (int i = 0; i < names.length; i++) {
            String[] fullName = names[i].split(" ");
            if (!fullName[1].equalsIgnoreCase(lastName))
                continue;
            String[] newFound = {names[i]};
            found = Arr.merge(found, newFound);
        }
        return found;
    }

    public static boolean remove(final String fullname) {
//        String[] allFoundFullname = findByFullname(fullname);
        String[] newArr = new String[names.length - 1];

        int l = names.length;
        int i = 0;
        int j = 0;

            while (l > 0) {
                if (!names[i].equalsIgnoreCase(fullname)){
                    newArr[j] = names[i];
                    i++; j++;
                } else {
                    i++;
                }
                l--;
        }
            names = newArr;


        return true;
    }


    public static String[] findByFullname(String fullname) {
        String[] found = new String[0];
        for (int i = 0; i < names.length; i++) {
            if (!names[i].equalsIgnoreCase(fullname))
                continue;
            String[] newFound = {names[i]};
            found = Arr.merge(found, newFound);
        }
        return found;
    }


}
