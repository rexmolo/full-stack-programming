package io.github.rexmolo.bookManagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;


    @Setter
    @Column(nullable = false, unique = true)
    private String isbn;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column
    private int maxLoanDays = 7;

    @Setter
    @ManyToMany(mappedBy = "writtenBooks")
    private Set<Author> authors;


    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }


    public void addAuthor(Author author) {
        authors.add(author);
        author.getWrittenBooks().add(this);
    }

    public void removeAuthor(Author author) {
        author.getWrittenBooks().remove(this);
        authors.remove(author);
    }
}
