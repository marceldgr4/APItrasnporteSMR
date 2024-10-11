package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Payments_Card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payments_Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_payment;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime date;

    // Relación con Transaction (muchos a uno)
    @ManyToOne
    @JoinColumn(name = "id_transaction")
    private Transaction transaction;

    // Relación uno a uno con History
    @OneToOne(mappedBy = "payment")  // Este 'mappedBy' debe apuntar al campo correcto en History
    private History history;

    // Relación con Bus (muchos a uno)
    @ManyToOne
    @JoinColumn(name = "id_Bus")
    private Bus buses;
}
