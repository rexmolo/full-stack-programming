package io.github.rexmolo.bookManagement.data.impl;

import io.github.rexmolo.bookManagement.data.AppUserDao;
import io.github.rexmolo.bookManagement.data.DetailsDao;
import io.github.rexmolo.bookManagement.entity.AppUser;
import io.github.rexmolo.bookManagement.entity.Details;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class AppUserImplTest {

    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;



    @Test
    void create() {
        Details details = detailsDao.create(new Details("jackie@gmail.com", "jackie"));
        AppUser user = new AppUser("jackie", "fdkjfdkjflas");
        user.setDetails(details);
        AppUser appUser = appUserDao.create(user);

        assertNotNull(appUser);

    }


//    @Test

//    void findAll() {
//        Collection<AppUser> appUsers = appUserDao.findAll();
//        appUsers.forEach(System.out::println);
//    }
}