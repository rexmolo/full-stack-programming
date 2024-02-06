package io.github.rexmolo.data.dao;


import java.util.Collection;

public interface BaseDAO<T> {


    T persist(T t);

    Collection<T> findAll();

    void remove(int id);
}
