package com.iOS.TranporteApp.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Buses")

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bus;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, unique = true)
    private Integer Capacity;

    @Column(nullable = false, unique = true)
    private String Brand;

    //ER



    @ManyToMany
    @JoinTable(name = "bus_ruta",
            joinColumns = @JoinColumn(name = "id_bus"),
            inverseJoinColumns = @JoinColumn(name = "id_ruta"))
    private Set<Ruta> ruta;

    @ManyToOne
    @JoinColumn(name = "id_conductor")
    private Conductor conductor;

    @OneToMany(mappedBy = "buses")
    private List<Payments> payments;

}
