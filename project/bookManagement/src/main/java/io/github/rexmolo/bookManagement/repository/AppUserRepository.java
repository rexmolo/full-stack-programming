package io.github.rexmolo.bookManagement.repository;

import io.github.rexmolo.bookManagement.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

}
