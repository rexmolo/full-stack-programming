package io.github.rexmolo.bookManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Details {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;

    @Setter
    @Column(length = 80, unique = true)
    private String email;

    @Setter
    @Column(length = 100)
    private String name;

    @Setter
    private LocalDate birthDate;


    public Details(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
