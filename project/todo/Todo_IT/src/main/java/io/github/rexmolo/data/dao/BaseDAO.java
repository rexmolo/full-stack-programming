package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.AppUser;

import java.util.Collection;

public interface BaseDAO<T> {


    AppUser persist(T t);

    Collection<T> findAll();

    void remove(int id);
}
