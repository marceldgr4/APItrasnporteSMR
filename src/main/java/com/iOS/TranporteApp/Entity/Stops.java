package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Stops")

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Stops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stop;

    @Column(nullable = false, unique = true)
    private String stop_name;

    @Column(nullable = false, unique = true)
    private String Location;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;





}
