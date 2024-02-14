package io.github.rexmolo.bookManagement.data.impl;

import io.github.rexmolo.bookManagement.data.AppUserDao;
import io.github.rexmolo.bookManagement.entity.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class AppUserImpl implements AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<AppUser> findByID(int id) {
        AppUser appUser = entityManager.find(AppUser.class, id);
        return Optional.ofNullable(appUser);
    }

    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT a from AppUser a", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
//        entityManager.merge(appUser);
//        return findByID(appUser.getAppUserId()).or;

        return null;
    }

    @Override
    public void delete(AppUser appUser) {
        entityManager.remove(appUser);
    }
}
