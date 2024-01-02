package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.AppUser;

public interface AppUserDAO extends BaseDAO<AppUser> {

    AppUser findByUsername(String username);
}
