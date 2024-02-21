package io.github.rexmolo.bookManagement.repository;

import io.github.rexmolo.bookManagement.entity.Details;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deal with err: Failed to load ApplicationContext
class DetailsRepositoryTest {

    @Autowired
    private DetailsRepository detailsRepository;

    @Transactional
    @Test
    void updateByDetailsId() {

        Details details = detailsRepository.findById(6).get();

        assertNotNull(details);

        detailsRepository.updateNameById("Jackie_M", details.getDetailsId());
    }
}