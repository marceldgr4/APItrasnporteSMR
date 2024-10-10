package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_User;

    @Column(nullable = false, unique = true)
    private String full_name;

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
    private List<History> HistoryList;

    @OneToMany(mappedBy = "user")
    private List<PQR> pqr;





}
