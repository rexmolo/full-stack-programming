package io.github.rexmolo.bookManagement.repository;

import io.github.rexmolo.bookManagement.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
