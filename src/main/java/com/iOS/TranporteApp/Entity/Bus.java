package com.iOS.TranporteApp.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Bus;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(nullable = false, unique = true)
    private String status;

    @Column(nullable = false, unique = true)
    private String type;

    @Column(nullable = false, unique = true)
    private String model;

    @Column(nullable = false, unique = true)
    private Integer Capacity;

    @Column(nullable = false, unique = true)
    private String Brand;

    //ER


    @ManyToMany
    @JoinTable(name = "Bus_locations",
            joinColumns = @JoinColumn(name = "id_Bus"),
            inverseJoinColumns = @JoinColumn(name = "id_Location")
    )
    private Set<Locations> location;

    @ManyToMany
    @JoinTable(
            name = "bus_ruta",
            joinColumns = @JoinColumn(name = "id_Bus"),
            inverseJoinColumns = @JoinColumn(name = "id_Ruta")
    )
    private Set<Ruta> ruta;

    @ManyToOne
    @JoinColumn(name = "id_Driver")
    private Drivers driver;

    @OneToMany(mappedBy = "buses")
    private List<Payments_Card> payments;



}
