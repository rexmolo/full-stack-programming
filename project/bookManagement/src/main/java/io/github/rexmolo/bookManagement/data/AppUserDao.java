package io.github.rexmolo.bookManagement.data;

import io.github.rexmolo.bookManagement.entity.AppUser;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> findByID(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(AppUser appUser);
}
