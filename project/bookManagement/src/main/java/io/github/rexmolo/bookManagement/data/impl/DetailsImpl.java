package io.github.rexmolo.bookManagement.data.impl;

import io.github.rexmolo.bookManagement.data.DetailsDao;
import io.github.rexmolo.bookManagement.entity.Details;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DetailsImpl implements DetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Details findById(int id) {
        return null;
    }

    @Override
    public Collection<Details> findAll() {
        return null;
    }

    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details update(Details details) {
        return null;
    }

    @Override
    public void delete(Details details) {

    }
}
