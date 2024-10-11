package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Rutas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Ruta;

    @Column(nullable = false, unique = true)
    private String route_name;

    @Column(nullable = false, unique = true)
    private String route_origen;

    @Column(nullable = false, unique = true)
    private String route_destination;

    @Column(nullable = false, unique = true)
    private String route_type;

    @Column(nullable = false, unique = true)
    private String route_status;

    @Column(nullable = false, unique = true)
    private Time Start_Time;

    @Column(nullable = false, unique = true)
    private Time End_Time;

//ERD

    @ManyToMany(mappedBy = "ruta")
    private Set<Bus> buses;


    @OneToMany(mappedBy = "ruta")
    private List<Stops> stops;






}
