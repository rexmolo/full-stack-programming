package io.github.rexmolo.bookManagement.repository;

import io.github.rexmolo.bookManagement.entity.BookLoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {


}
