package se.lexicon.data;


import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Create implementations for all methods.
 * I have already provided an implementation for the first method.
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl() {
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance() {
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (filter.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        for (Person p : personList) {
            if (filter.test(p))
                return p;
        }
        return null;
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        Person person = this.findOne(filter);
        return personToString.apply(person);
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString) {
        List<Person> foundPersons = this.findMany(filter);
        List<String> res = new ArrayList<>();
        for (Person p : foundPersons) {
            res.add(personToString.apply(p));
        }
        return res;
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer) {
        List<Person> pls = this.findMany(filter);
        pls.forEach(consumer);
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator) {
        //todo: implement the method

        return null;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator) {
        //todo: implement the method
        return null;
    }
}
