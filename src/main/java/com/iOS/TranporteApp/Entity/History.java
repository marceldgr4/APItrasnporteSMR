package com.iOS.TranporteApp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Historys")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_history;

    @Column(nullable = false)
    private LocalDateTime date_history;


    // Relación uno a uno con Transaction
    @OneToOne(mappedBy = "history")
    private Transaction transaction;

    @OneToOne(mappedBy = "history")
    private User user;

}
