package io.github.rexmolo.bookManagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}
