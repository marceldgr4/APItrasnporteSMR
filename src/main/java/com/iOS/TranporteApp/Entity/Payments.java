package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Payments_Card")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_payment;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime date;


    @OneToOne
    @JoinColumn(name = "id_transaction")
    private Transaction transaction;


    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;


    @ManyToOne
    @JoinColumn(name = "id_bus")
    private Bus buses;
}
