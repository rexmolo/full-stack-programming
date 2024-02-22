package io.github.rexmolo.bookManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Setter
    private String firstName;

    @Setter
    private String lastName;
    @Setter
    @ManyToMany
    @JoinTable(name = "author_books_rel",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> writtenBooks;

    public void addWrittenBooks(Book book) {
        writtenBooks.add(book);
        book.getAuthors().add(this);
    }
    
    public void removeWrittenBooks(Book book) {
        book.getAuthors().remove(this);
        writtenBooks.remove(book);
    }

}
