package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "Users")

@NoArgsConstructor
@AllArgsConstructor
@Builder


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(nullable = false, unique = true)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false, unique = true)
    private Integer phone;

    @Column(nullable = false, unique = true)
    private String Rol;

    @Column(nullable = false, unique = true)
    private Timestamp created_at;

    //ER

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;

    @OneToMany(mappedBy = "user")
    private List<History> historyList;

    @OneToMany(mappedBy = "user")
    private List<PQR> pqr;





}
