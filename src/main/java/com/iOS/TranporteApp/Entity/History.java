package com.iOS.TranporteApp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Historys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_history;

    @Column(nullable = false)
    private LocalDateTime date_history;

    // Relación muchos a uno con User
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // Relación uno a uno con Payments_Card
    @OneToOne
    @JoinColumn(name = "id_payment")
    private Payments_Card payment;

    // Relación uno a uno con Transaction
    @OneToOne(mappedBy = "history")
    private Transaction transaction;
}
