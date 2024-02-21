package io.github.rexmolo.bookManagement.repository;

import io.github.rexmolo.bookManagement.entity.Details;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {

    @Modifying
    @Query("update Details d set d.name=?1 where d.detailsId=?2")
    void updateNameById(String name, int Id);
}
