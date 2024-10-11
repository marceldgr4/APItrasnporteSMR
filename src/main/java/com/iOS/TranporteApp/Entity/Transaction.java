package com.iOS.TranporteApp.Entity;
import com.iOS.TranporteApp.Emun.TypeTransaction;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaction;

    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;

    @Column(nullable = false, unique = true)
    private LocalDateTime date_transaction;

    @Column(nullable = false, unique = true)
    private Double amount;
//ERD
    @OneToOne
    @JoinColumn(name = "id_history")
    private History history;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;

    @OneToMany(mappedBy = "transaction")
    private List<Payments_Card> payments;


}
