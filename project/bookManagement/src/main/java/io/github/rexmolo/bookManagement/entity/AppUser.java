package io.github.rexmolo.bookManagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@NoArgsConstructor

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    private LocalDate regdate;



    @Setter
    @OneToOne
    @JoinColumn(name = "details_id")
    private Details details;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.regdate = LocalDate.now();

    }

}
