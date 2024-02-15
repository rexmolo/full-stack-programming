package io.github.rexmolo.bookManagement;
import io.github.rexmolo.bookManagement.data.AppUserDao;
import io.github.rexmolo.bookManagement.data.DetailsDao;
import io.github.rexmolo.bookManagement.entity.AppUser;
import io.github.rexmolo.bookManagement.entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private final AppUserDao appUserDao;
    private final DetailsDao detailsDao;

    @Autowired
    public MyCommandLineRunner(AppUserDao appUserDao, DetailsDao detailsDao) {
        this.appUserDao = appUserDao;
        this.detailsDao = detailsDao;
    }

    @Override
    public void run(String... args) throws Exception {

//        Details details = new Details("jackie@gmail.com", "jackie");
//        Details details1 = this.detailsDao.create(details);
//
//        AppUser user3 = new AppUser("jackie", "fdkjfdkjflas");
//        user3.setDetails(details1);
//        appUserDao.create(user3);

    }
}