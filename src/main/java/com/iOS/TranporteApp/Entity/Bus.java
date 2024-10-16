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
    @JoinTable(name = "bus_locations",
            joinColumns = @JoinColumn(name = "id_bus"),
            inverseJoinColumns = @JoinColumn(name = "id_location"))
    private Set<Locations> location;

    @ManyToMany
    @JoinTable(name = "bus_ruta",
            joinColumns = @JoinColumn(name = "id_Bus"),
            inverseJoinColumns = @JoinColumn(name = "id_Ruta"))
    private Set<Ruta> ruta;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Drivers driver;

    @OneToMany(mappedBy = "buses")
    private List<Payments_Card> payments;

}
