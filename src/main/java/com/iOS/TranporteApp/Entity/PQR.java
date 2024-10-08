package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PQRS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PQR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_PQR;

    @Column(nullable = false)
    private String Comments;

    @Column(nullable = false)
    private LocalDateTime Data_Register;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;



}
