package io.github.rexmolo.bookManagement.data.impl;

import io.github.rexmolo.bookManagement.data.AppUserDao;
import io.github.rexmolo.bookManagement.entity.AppUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
//@Rollback
class AppUserImplTest {

    @Autowired
    AppUserDao appUserDao;

    @Test
    void create() {
        AppUser appUser = appUserDao.create(new AppUser("jackie", "fdkjfdkjflas"));
        assertNotNull(appUser);

    }


    @Test

    void findAll() {
        Collection<AppUser> appUsers = appUserDao.findAll();
        appUsers.forEach(System.out::println);
    }
}